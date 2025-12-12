package eu.codlab.permissions.bluetooth

import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_SCAN
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_CONNECT
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_ADVERTISE
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_LE

actual val PermissionBluetoothLE: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_LE,
        toPlatformPermissions = listOf()
    )

actual val PermissionBluetoothScan: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_SCAN,
        toPlatformPermissions = listOf()
    )

actual val PermissionBluetoothConnect: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_CONNECT,
        toPlatformPermissions = listOf()
    )

actual val PermissionBluetoothAdvertise: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_ADVERTISE,
        toPlatformPermissions = listOf()
    )
