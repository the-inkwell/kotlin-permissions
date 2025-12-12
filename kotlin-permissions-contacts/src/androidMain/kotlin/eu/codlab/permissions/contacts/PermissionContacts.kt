package eu.codlab.permissions.contacts

import android.Manifest
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.contacts.CONTACTS

actual val PermissionContacts: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.CONTACTS,
        toPlatformPermissions = listOf(
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.READ_CONTACTS
        )
    )
