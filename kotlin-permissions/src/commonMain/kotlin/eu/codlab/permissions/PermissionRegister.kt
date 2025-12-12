package eu.codlab.permissions

object PermissionRegister {
    private val map = mutableMapOf<InternalPermissionDef, Permission>()

    fun register(permission: Permission) {
        map[permission.moko as InternalPermissionDef] = permission
    }

    fun internalPermissionFrom(def: InternalPermissionDef) = map[def]
}