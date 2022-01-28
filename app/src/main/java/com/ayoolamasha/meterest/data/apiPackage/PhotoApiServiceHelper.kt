package com.ayoolamasha.meterest.data.apiPackage


import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import retrofit2.Response

interface PhotoApiServiceHelper {

    suspend fun getAllPhotos(): Response<List<GetPhotoListResponse>>

    suspend fun getAllPhotosPaging(page:Int?, perPage:Int?, orderBy:String?): Response<List<GetPhotoListResponse>>

}