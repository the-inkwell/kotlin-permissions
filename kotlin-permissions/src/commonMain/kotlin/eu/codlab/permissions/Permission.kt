package eu.codlab.permissions

/* enum */ class Permission(
    internal val moko: Any,
    internal val toPlatformPermissions: List<String>
) {
    init {
        PermissionRegister.register(this)
    }

    // CAMERA,

    // // GALLERY,
    // // STORAGE,
    // WRITE_STORAGE,

    // // LOCATION,
    // // COARSE_LOCATION,
    // // BLUETOOTH_LE,
    // REMOTE_NOTIFICATION,
    // RECORD_AUDIO,
    // BLUETOOTH_SCAN,
    // BLUETOOTH_ADVERTISE,
    // BLUETOOTH_CONNECT
}
