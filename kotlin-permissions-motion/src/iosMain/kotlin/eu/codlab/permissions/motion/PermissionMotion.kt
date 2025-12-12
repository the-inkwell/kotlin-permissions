package eu.codlab.permissions.motion

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.motion.MOTION

actual val PermissionMotion: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.MOTION,
        toPlatformPermissions = listOf()
    )
