package eu.codlab.permissions.microphone

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.microphone.RECORD_AUDIO

actual val PermissionMicrophone: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.RECORD_AUDIO,
        toPlatformPermissions = listOf()
    )
