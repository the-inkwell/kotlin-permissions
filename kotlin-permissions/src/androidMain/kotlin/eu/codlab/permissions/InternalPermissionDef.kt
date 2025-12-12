package eu.codlab.permissions

import dev.icerock.moko.permissions.Permission

actual typealias InternalPermissionDef = Permission

fun eu.codlab.permissions.Permission.toMoKo(): InternalPermissionDef {
    return moko as InternalPermissionDef
}
