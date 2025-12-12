package eu.codlab.permissions.notifications

import android.Manifest
import android.os.Build
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.notifications.REMOTE_NOTIFICATION

actual val PermissionNotifications: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.REMOTE_NOTIFICATION,
        toPlatformPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            emptyList()
        }
    )
