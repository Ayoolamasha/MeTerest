package com.ayoolamasha.meterest.data.roomPackage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayoolamasha.meterest.data.roomPackage.dao.PhotosDao

@Database(entities = [PhotosEntity::class], exportSchema = false, version = 1)
abstract class PhotosRoomDataBase: RoomDatabase() {
    abstract fun photosDao(): PhotosDao
}