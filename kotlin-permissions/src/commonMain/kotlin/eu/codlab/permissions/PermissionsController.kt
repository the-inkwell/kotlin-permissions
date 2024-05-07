package eu.codlab.permissions

expect class PermissionsController() {
    suspend fun providePermission(permission: Permission)
    suspend fun isGranted(permission: Permission): Boolean
    suspend fun getState(permission: Permission): PermissionState

    fun canOpenAppSettings(): Boolean
    fun openAppSettings()
}
