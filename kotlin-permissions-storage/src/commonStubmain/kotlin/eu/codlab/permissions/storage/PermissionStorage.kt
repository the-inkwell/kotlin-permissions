package eu.codlab.permissions.storage

import eu.codlab.permissions.None

actual val PermissionReadStorage: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )

actual val PermissionWriteStorage: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
