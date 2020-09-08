package com.alawiyaa.instagramprofile.data.local

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {


    internal class NoteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "tb_gallery"
            const val _ID = "_id"
            const val LOCATION_NAME = "name"
            const val DISPLAY_URL = "display_url"
            const val USERNAME = "username"
            const val FULL_NAME = "full_name"
            const val BIOGRAPHY = "biography"
            const val FOLLOWERS = "count"
            const val FOLLOWING = "count"
            const val IMAGE = "profile_pic_url_hd"

        }

    }
}