package eu.codlab.permissions.storage

import android.Manifest
import android.os.Build
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.storage.STORAGE
import dev.icerock.moko.permissions.storage.WRITE_STORAGE

actual val PermissionReadStorage: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.STORAGE,
        toPlatformPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO
            )
        } else {
            listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    )

actual val PermissionWriteStorage: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.WRITE_STORAGE,
        toPlatformPermissions = listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    )
