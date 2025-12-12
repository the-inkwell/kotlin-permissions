package eu.codlab.permissions.bluetooth

import android.Manifest
import android.os.Build
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_SCAN
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_CONNECT
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_ADVERTISE
import dev.icerock.moko.permissions.bluetooth.BLUETOOTH_LE

actual val PermissionBluetoothLE: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_LE,
        toPlatformPermissions = allBluetoothPermissions()
    )

actual val PermissionBluetoothScan: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_SCAN,
        toPlatformPermissions = bluetoothScanCompat()
    )

actual val PermissionBluetoothConnect: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_CONNECT,
        toPlatformPermissions = bluetoothConnectCompat()
    )

actual val PermissionBluetoothAdvertise: eu.codlab.permissions.Permission
    get() = eu.codlab.permissions.Permission(
        moko = Permission.BLUETOOTH_ADVERTISE,
        toPlatformPermissions = bluetoothAdvertiseCompat()
    )

/**
 * @see https://developer.android.com/guide/topics/connectivity/bluetooth/permissions
 */
private fun allBluetoothPermissions() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        listOf(
            Manifest.permission.BLUETOOTH_CONNECT,
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_ADVERTISE,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    } else {
        listOf(
            Manifest.permission.BLUETOOTH,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

private fun bluetoothScanCompat() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        listOf(Manifest.permission.BLUETOOTH_SCAN)
    } else {
        listOf(Manifest.permission.BLUETOOTH)
    }

private fun bluetoothAdvertiseCompat() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        listOf(Manifest.permission.BLUETOOTH_ADVERTISE)
    } else {
        listOf(Manifest.permission.BLUETOOTH)
    }

private fun bluetoothConnectCompat() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        listOf(Manifest.permission.BLUETOOTH_CONNECT)
    } else {
        listOf(Manifest.permission.BLUETOOTH)
    }
