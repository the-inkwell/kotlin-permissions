package eu.codlab.permissions

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri

class PermissionProvider : ContentProvider() {
    private val defaultAuthority: String = "eu.codlab.permissions."

    override fun onCreate(): Boolean {
        // nothing
        return true
    }

    override fun attachInfo(context: Context, info: ProviderInfo?) {
        PermissionsController.setApplicationContext(context)

        super.attachInfo(context, info)
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        // nothing to do
        return null
    }

    override fun getType(p0: Uri): String? {
        // nothing to do
        return null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        // nothing to do
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        // nothing to do
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        // nothing to do
        return 0
    }
}
