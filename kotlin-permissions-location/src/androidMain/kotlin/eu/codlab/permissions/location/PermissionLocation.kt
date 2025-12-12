package eu.codlab.permissions.location

import android.Manifest
import android.os.Build
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.location.LOCATION

actual val PermissionLocation: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.LOCATION,
        toPlatformPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        } else {
            listOf(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    )

actual val PermissionCoarseLocation: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.LOCATION,
        toPlatformPermissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

actual val PermissionBackgroundLocation: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.LOCATION,
        toPlatformPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(
                Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            )
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            listOf(
                Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            )
        } else {
            emptyList()
        }
    )