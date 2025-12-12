package eu.codlab.permissions.gallery

import eu.codlab.permissions.None

actual val PermissionGallery: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
