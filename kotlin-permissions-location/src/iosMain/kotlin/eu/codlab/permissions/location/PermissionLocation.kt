package eu.codlab.permissions.location

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.location.BACKGROUND_LOCATION
import dev.icerock.moko.permissions.location.COARSE_LOCATION
import dev.icerock.moko.permissions.location.LOCATION

actual val PermissionLocation: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.LOCATION,
        toPlatformPermissions = listOf()
    )

actual val PermissionCoarseLocation: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.COARSE_LOCATION,
        toPlatformPermissions = listOf()
    )

actual val PermissionBackgroundLocation: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BACKGROUND_LOCATION,
        toPlatformPermissions = listOf()
    )
