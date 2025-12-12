package eu.codlab.permissions.motion

import android.Manifest
import android.os.Build
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.motion.MOTION

actual val PermissionMotion: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.MOTION,
        toPlatformPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(
                Manifest.permission.ACTIVITY_RECOGNITION,
                Manifest.permission.BODY_SENSORS
            )
        } else {
            listOf(Manifest.permission.BODY_SENSORS)
        }
    )
