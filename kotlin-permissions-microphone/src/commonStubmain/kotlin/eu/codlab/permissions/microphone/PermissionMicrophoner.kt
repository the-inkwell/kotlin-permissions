package eu.codlab.permissions.microphone

import eu.codlab.permissions.None

actual val PermissionMicrophone: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = object : None {},
        toPlatformPermissions = listOf()
    )
