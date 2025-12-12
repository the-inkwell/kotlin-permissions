package eu.codlab.permissions.camera

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.camera.CAMERA

actual val PermissionCamera: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.CAMERA,
        toPlatformPermissions = listOf()
    )
