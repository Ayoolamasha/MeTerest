package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import com.ayoolamasha.meterest.data.roomPackage.PhotosRoomDataBase
import com.ayoolamasha.meterest.domain.PhotoUICase
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val photosRoomDataBase: PhotosRoomDataBase
): CacheRepository {
    override fun saveToDB(photosEntity: List<GetPhotoListResponse>) {
        photosRoomDataBase.photosDao().clearAndInsertRoomPhotos(photosEntity.map{photosList ->  photosList.fromApiToPhotoEntity()})
    }

    override fun fetchFromDB(): List<PhotoUICase> {
        val localResult = photosRoomDataBase.photosDao().getAllRoomPhotosList()
        return localResult.map { entityList -> entityList.fromRoomToPhotoUiCase() }
    }
}