package com.alawiyaa.instagramprofile.data.local

import androidx.room.Dao
import androidx.room.Query


@Dao
interface GalleryDAO {
    @Query("DELETE FROM contacts")
    fun deleteAll()

    @Query("DELETE FROM contacts WHERE id = :id")
    fun delete(id: Int)
}