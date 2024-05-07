package eu.codlab.permissions

actual class PermissionsController actual constructor() {
    actual suspend fun providePermission(permission: Permission) {
        // nothing to do
    }

    actual suspend fun isGranted(permission: Permission): Boolean {
        return true
    }

    actual suspend fun getState(permission: Permission): PermissionState {
        return PermissionState.Granted
    }

    actual fun canOpenAppSettings(): Boolean {
        return false
    }

    actual fun openAppSettings() {
        // nothing
    }
}
