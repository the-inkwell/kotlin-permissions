package eu.codlab.permissions

actual class PermissionsController actual constructor() {
    actual suspend fun providePermission(permission: Permission) {
        // nothing to do
    }

    actual suspend fun isGranted(permission: Permission): Boolean {
        return false
    }

    actual suspend fun getState(permission: Permission): PermissionState {
        return PermissionState.DeniedAlways
    }

    actual fun canOpenAppSettings(): Boolean {
        return false
    }

    actual fun openAppSettings() {
        // can't be used
    }
}
