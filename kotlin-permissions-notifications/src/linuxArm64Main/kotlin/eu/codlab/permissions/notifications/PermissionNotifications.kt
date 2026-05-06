package eu.codlab.permissions.notifications

import eu.codlab.permissions.None

actual val PermissionNotifications: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
