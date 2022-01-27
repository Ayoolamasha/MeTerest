package com.ayoolamasha.meterest.data.roomPackage.dao

import androidx.lifecycle.LiveData
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoDaoImpl @Inject constructor(private val photosDao: PhotosDao): PhotoDaoHelper{
    override fun getAllRoomPhotos(): LiveData<List<PhotosEntity>> {
        return photosDao.getAllRoomPhotos()
    }

//    override suspend fun getRoomPhotoById(photoId: String): Flow<PhotosEntity> {
//        return photosDao.getRoomPhotoById(photoId)
//    }

    override suspend fun clearAndInsertRoomPhotos(photosEntity: List<PhotosEntity>) {
        return photosDao.clearAndInsertRoomPhotos(photosEntity)
    }
}