package eu.codlab.permissions.camera

import eu.codlab.permissions.None

actual val PermissionCamera: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
