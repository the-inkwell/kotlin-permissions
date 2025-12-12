package eu.codlab.permissions.storage

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.storage.STORAGE
import dev.icerock.moko.permissions.storage.WRITE_STORAGE

actual val PermissionReadStorage: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.STORAGE,
        toPlatformPermissions = listOf()
    )

actual val PermissionWriteStorage: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.WRITE_STORAGE,
        toPlatformPermissions = listOf()
    )
