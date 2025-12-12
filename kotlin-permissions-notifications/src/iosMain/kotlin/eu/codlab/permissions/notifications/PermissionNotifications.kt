package eu.codlab.permissions.notifications

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.notifications.REMOTE_NOTIFICATION

actual val PermissionNotifications: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.REMOTE_NOTIFICATION,
        toPlatformPermissions = listOf()
    )
