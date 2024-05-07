package eu.codlab.permissions

typealias InternalPermission = dev.icerock.moko.permissions.Permission
typealias InternalPermissionState = dev.icerock.moko.permissions.PermissionState

fun translate(permission: Permission): InternalPermission {
    return when (permission) {
        Permission.CAMERA -> InternalPermission.CAMERA
        Permission.WRITE_STORAGE -> InternalPermission.WRITE_STORAGE
        Permission.REMOTE_NOTIFICATION -> InternalPermission.REMOTE_NOTIFICATION
        Permission.RECORD_AUDIO -> InternalPermission.RECORD_AUDIO
        Permission.BLUETOOTH_SCAN -> InternalPermission.BLUETOOTH_SCAN
        Permission.BLUETOOTH_ADVERTISE -> InternalPermission.BLUETOOTH_ADVERTISE
        Permission.BLUETOOTH_CONNECT -> InternalPermission.BLUETOOTH_CONNECT
    }
}

fun state(state: dev.icerock.moko.permissions.PermissionState): PermissionState {
    return when (state) {
        InternalPermissionState.NotDetermined -> PermissionState.NotDetermined
        InternalPermissionState.Granted -> PermissionState.Granted
        InternalPermissionState.Denied -> PermissionState.Denied
        InternalPermissionState.DeniedAlways -> PermissionState.DeniedAlways
    }
}

actual class PermissionsController {
    private val permissionController = dev.icerock.moko.permissions.ios.PermissionsController()

    actual suspend fun providePermission(permission: Permission) =
        permissionController.providePermission(translate(permission))

    actual suspend fun isGranted(permission: Permission): Boolean =
        permissionController.isPermissionGranted(translate(permission))

    actual suspend fun getState(permission: Permission): PermissionState =
        state(permissionController.getPermissionState(translate(permission)))

    actual fun canOpenAppSettings(): Boolean = true

    actual fun openAppSettings() {
        permissionController.openAppSettings()
    }
}
