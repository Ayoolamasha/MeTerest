package com.ayoolamasha.meterest.data.roomPackage.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PhotosDao {
    @Insert
    abstract suspend fun insertPhotos(photosEntity: List<PhotosEntity>)

    @Query("DELETE FROM PHOTOS_TABLE")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM PHOTOS_TABLE")
    abstract fun getAllRoomPhotos(): LiveData<List<PhotosEntity>>

//    @Query("SELECT * FROM PHOTOS_TABLE WHERE photoId = :photoId")
//    abstract suspend fun getRoomPhotoById(photoId:String): LiveData<PhotosEntity>

    @Transaction
    open suspend fun clearAndInsertRoomPhotos(photosEntity: List<PhotosEntity>){
        deleteAll()
        insertPhotos(photosEntity)
    }
}