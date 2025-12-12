package eu.codlab.permissions.contacts

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.contacts.CONTACTS

actual val PermissionContacts: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.CONTACTS,
        toPlatformPermissions = listOf()
    )
