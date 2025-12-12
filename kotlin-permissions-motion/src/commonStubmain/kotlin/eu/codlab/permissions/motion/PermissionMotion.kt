package eu.codlab.permissions.motion

import eu.codlab.permissions.None

actual val PermissionMotion: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
