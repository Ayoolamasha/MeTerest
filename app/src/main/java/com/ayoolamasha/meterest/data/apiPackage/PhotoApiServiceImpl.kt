package com.ayoolamasha.meterest.data.apiPackage

import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import retrofit2.Response
import javax.inject.Inject

class PhotoApiServiceImpl @Inject constructor(private val photoApiService: PhotoApiService): PhotoApiServiceHelper {

    override suspend fun getAllPhotos(): Response<List<GetPhotoListResponse>> {
        return photoApiService.getAllPhotos()
    }

}