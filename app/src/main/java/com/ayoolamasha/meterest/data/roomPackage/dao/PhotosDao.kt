package com.ayoolamasha.meterest.data.roomPackage.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PhotosDao {
    @Insert
    abstract fun insertPhotos(photosEntity: List<PhotosEntity>)

    @Query("DELETE FROM PHOTOS_TABLE")
    abstract fun deleteAll()

    @Query("SELECT * FROM PHOTOS_TABLE")
    abstract fun getAllRoomPhotos(): LiveData<List<PhotosEntity>>

    @Query("SELECT * FROM PHOTOS_TABLE")
    abstract fun getAllRoomPhotosList(): List<PhotosEntity>

//    @Query("SELECT * FROM PHOTOS_TABLE WHERE photoId = :photoId")
//    abstract suspend fun getRoomPhotoById(photoId:String): LiveData<PhotosEntity>

    @Transaction
    open fun clearAndInsertRoomPhotos(photosEntity: List<PhotosEntity>){
        deleteAll()
        insertPhotos(photosEntity)
    }
}