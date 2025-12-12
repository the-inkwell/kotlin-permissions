package eu.codlab.permissions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

typealias InternalPermissionsController = PermissionsControllerImpl
typealias InternalPermission = dev.icerock.moko.permissions.Permission
typealias InternalPermissionState = dev.icerock.moko.permissions.PermissionState

actual class PermissionsController {
    companion object {
        private var applicationContext: Context? = null
        private var activity: FragmentActivity? = null
        private var permissionController: InternalPermissionsController? = null

        internal fun setApplicationContext(context: Context) {
            applicationContext = context
        }

        fun setActivity(activity: FragmentActivity) {
            this.activity = activity
            permissionController = PermissionsControllerImpl(activity, applicationContext!!)
        }

        private val VERSIONS_WITHOUT_NOTIFICATION_PERMISSION =
            Build.VERSION_CODES.KITKAT until Build.VERSION_CODES.TIRAMISU
    }

    actual suspend fun providePermission(permission: Permission) =
        permissionController!!.providePermission(permission.toMoKo())

    actual suspend fun isGranted(permission: Permission): Boolean {
        if (null != applicationContext && null == activity) {
            return isPermissionGrantedSync(permission.toMoKo())
        }
        return permissionController!!.isPermissionGranted(permission.toMoKo())
    }

    actual suspend fun getState(permission: Permission): PermissionState =
        state(permissionController!!.getPermissionState(permission.toMoKo()))

    actual fun canOpenAppSettings(): Boolean = true

    actual fun openAppSettings() {
        permissionController!!.openAppSettings()
    }

    private fun isPermissionGrantedSync(permission: dev.icerock.moko.permissions.Permission): Boolean {
        val permissions = PermissionRegister.internalPermissionFrom(permission)!!.toPlatformPermissions

        if (permissions.contains(Manifest.permission.POST_NOTIFICATIONS) &&
            Build.VERSION.SDK_INT in VERSIONS_WITHOUT_NOTIFICATION_PERMISSION
        ) {
            return NotificationManagerCompat.from(applicationContext!!).areNotificationsEnabled()
        }

        return permissions.all {
            val status = ContextCompat.checkSelfPermission(applicationContext!!, it)
            status == PackageManager.PERMISSION_GRANTED
        }
    }
}
