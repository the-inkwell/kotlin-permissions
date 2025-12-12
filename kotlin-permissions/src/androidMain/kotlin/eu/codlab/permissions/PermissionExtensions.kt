package eu.codlab.permissions

import android.Manifest
import android.os.Build

/*internal fun InternalPermission.toPlatformPermission(): List<String> {
    return when (this) {
        InternalPermission.CAMERA -> listOf(Manifest.permission.CAMERA)
        InternalPermission.GALLERY -> listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        InternalPermission.STORAGE -> listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        InternalPermission.WRITE_STORAGE -> listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        InternalPermission.LOCATION -> listOf(Manifest.permission.ACCESS_FINE_LOCATION)
        InternalPermission.COARSE_LOCATION -> listOf(Manifest.permission.ACCESS_COARSE_LOCATION)
        InternalPermission.REMOTE_NOTIFICATION -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                listOf(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                emptyList()
            }
        }

        InternalPermission.RECORD_AUDIO -> listOf(Manifest.permission.RECORD_AUDIO)
        // InternalPermission.BLUETOOTH_LE -> allBluetoothPermissions()
        // InternalPermission.BLUETOOTH_SCAN -> bluetoothScanCompat()
        // InternalPermission.BLUETOOTH_ADVERTISE -> bluetoothAdvertiseCompat()
        InternalPermission.BLUETOOTH_CONNECT -> bluetoothConnectCompat()
        dev.icerock.moko.permissions.Permission.BACKGROUND_LOCATION -> TODO()
        dev.icerock.moko.permissions.Permission.CONTACTS -> TODO()
        dev.icerock.moko.permissions.Permission.MOTION -> TODO()
    }
}

internal fun Permission.toMoKo(): InternalPermission {
    return when (this) {
        Permission.CAMERA -> InternalPermission.CAMERA
        Permission.WRITE_STORAGE -> InternalPermission.WRITE_STORAGE
        Permission.REMOTE_NOTIFICATION -> InternalPermission.REMOTE_NOTIFICATION
        Permission.RECORD_AUDIO -> InternalPermission.RECORD_AUDIO
        // Permission.BLUETOOTH_SCAN -> InternalPermission.BLUETOOTH_SCAN
        // Permission.BLUETOOTH_ADVERTISE -> InternalPermission.BLUETOOTH_ADVERTISE
        // Permission.BLUETOOTH_CONNECT -> InternalPermission.BLUETOOTH_CONNECT
    }
}*/

internal fun state(state: dev.icerock.moko.permissions.PermissionState): PermissionState {
    return when (state) {
        InternalPermissionState.NotDetermined -> PermissionState.NotDetermined
        InternalPermissionState.Granted -> PermissionState.Granted
        InternalPermissionState.Denied -> PermissionState.Denied
        InternalPermissionState.DeniedAlways -> PermissionState.DeniedAlways
        dev.icerock.moko.permissions.PermissionState.NotGranted -> TODO()
    }
}