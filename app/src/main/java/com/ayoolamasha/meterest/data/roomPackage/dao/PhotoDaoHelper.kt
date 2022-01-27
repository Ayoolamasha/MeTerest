package com.ayoolamasha.meterest.data.roomPackage.dao

import androidx.lifecycle.LiveData
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import kotlinx.coroutines.flow.Flow


interface PhotoDaoHelper {
    fun getAllRoomPhotos(): LiveData<List<PhotosEntity>>

    //suspend fun getRoomPhotoById(photoId:String): LiveData<PhotosEntity>

    suspend fun clearAndInsertRoomPhotos(photosEntity: List<PhotosEntity>)
}