package eu.codlab.permissions.gallery

import android.Manifest
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.gallery.GALLERY

actual val PermissionGallery: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.GALLERY,
        toPlatformPermissions = listOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_VIDEO
        )
    )
