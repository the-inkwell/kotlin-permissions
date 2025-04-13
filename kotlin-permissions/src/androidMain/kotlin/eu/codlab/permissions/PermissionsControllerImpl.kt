package eu.codlab.permissions

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

@Suppress("TooManyFunctions")
class PermissionsControllerImpl(
    private val activity: FragmentActivity,
    private val applicationContext: Context
) {
    private var continuation: Continuation<Boolean>? = null

    val requestSinglePermission =
        activity.registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { result -> continuation!!.resumeWith(Result.success(result)) }

    val requestMultiplePermissions = activity.registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val granted = result.values.all { it }
        continuation!!.resumeWith(Result.success(granted))
    }

    suspend fun providePermission(permission: Permission) {
        val platformPermissions = permission.toPlatformPermission()

        suspendCoroutine { newContinuation ->
            continuation = newContinuation
            if (platformPermissions.size == 1) {
                requestSinglePermission.launch(platformPermissions[0])
            } else {
                requestMultiplePermissions.launch(platformPermissions.toTypedArray())
            }
        }
    }

    suspend fun isPermissionGranted(permission: Permission): Boolean {
        return getPermissionState(permission) == PermissionState.Granted
    }

    @Suppress("ReturnCount")
    suspend fun getPermissionState(permission: Permission): PermissionState {
        if (permission == Permission.REMOTE_NOTIFICATION &&
            Build.VERSION.SDK_INT in VERSIONS_WITHOUT_NOTIFICATION_PERMISSION
        ) {
            val isNotificationsEnabled = NotificationManagerCompat.from(applicationContext)
                .areNotificationsEnabled()
            return if (isNotificationsEnabled) {
                PermissionState.Granted
            } else {
                PermissionState.DeniedAlways
            }
        }
        val permissions: List<String> = permission.toPlatformPermission()
        val status: List<Int> = permissions.map {
            ContextCompat.checkSelfPermission(applicationContext, it)
        }
        val isAllGranted: Boolean = status.all { it == PackageManager.PERMISSION_GRANTED }
        if (isAllGranted) return PermissionState.Granted

        val isAllRequestRationale: Boolean = permissions.all {
            !activity.shouldShowRequestPermissionRationale(it)
        }
        return if (isAllRequestRationale) {
            PermissionState.NotDetermined
        } else {
            PermissionState.Denied
        }
    }

    fun openAppSettings() {
        val intent = Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = Uri.fromParts("package", applicationContext.packageName, null)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        applicationContext.startActivity(intent)
    }

    private fun Permission.toPlatformPermission(): List<String> {
        return when (this) {
            Permission.CAMERA -> listOf(Manifest.permission.CAMERA)
            Permission.GALLERY -> galleryCompat()
            Permission.STORAGE -> allStoragePermissions()
            Permission.WRITE_STORAGE -> listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            Permission.LOCATION -> fineLocationCompat()
            Permission.COARSE_LOCATION -> listOf(Manifest.permission.ACCESS_COARSE_LOCATION)
            Permission.REMOTE_NOTIFICATION -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    listOf(Manifest.permission.POST_NOTIFICATIONS)
                } else {
                    emptyList()
                }
            }

            Permission.RECORD_AUDIO -> listOf(Manifest.permission.RECORD_AUDIO)
            Permission.BLUETOOTH_LE -> allBluetoothPermissions()
            Permission.BLUETOOTH_SCAN -> bluetoothScanCompat()
            Permission.BLUETOOTH_ADVERTISE -> bluetoothAdvertiseCompat()
            Permission.BLUETOOTH_CONNECT -> bluetoothConnectCompat()
            Permission.BACKGROUND_LOCATION -> TODO()
            Permission.CONTACTS -> TODO()
            Permission.MOTION -> TODO()
        }
    }

    /**
     * Behavior changes: Apps targeting Android 13 or higher
     *
     * @see https://developer.android.com/about/versions/13/behavior-changes-13#granular-media-permissions
     */

    private fun allStoragePermissions() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO
            )
        } else {
            listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

    private fun galleryCompat() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO
            )
        } else {
            listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

    private fun fineLocationCompat() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            listOf(Manifest.permission.ACCESS_FINE_LOCATION)
        }

    /**
     * Bluetooth permissions
     *
     * @see https://developer.android.com/guide/topics/connectivity/bluetooth/permissions
     */

    private fun allBluetoothPermissions() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_ADVERTISE,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            listOf(
                Manifest.permission.BLUETOOTH,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        }

    private fun bluetoothScanCompat() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(Manifest.permission.BLUETOOTH_SCAN)
        } else {
            listOf(Manifest.permission.BLUETOOTH)
        }

    private fun bluetoothAdvertiseCompat() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(Manifest.permission.BLUETOOTH_ADVERTISE)
        } else {
            listOf(Manifest.permission.BLUETOOTH)
        }

    private fun bluetoothConnectCompat() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(Manifest.permission.BLUETOOTH_CONNECT)
        } else {
            listOf(Manifest.permission.BLUETOOTH)
        }

    private companion object {
        val VERSIONS_WITHOUT_NOTIFICATION_PERMISSION =
            Build.VERSION_CODES.KITKAT until Build.VERSION_CODES.TIRAMISU
    }
}
