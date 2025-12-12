package eu.codlab.permissions.contacts

import eu.codlab.permissions.None

actual val PermissionContacts: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
