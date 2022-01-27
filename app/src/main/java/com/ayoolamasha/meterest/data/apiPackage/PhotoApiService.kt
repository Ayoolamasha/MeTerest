package com.ayoolamasha.meterest.data.apiPackage

import com.ayoolamasha.meterest.data.CLIENT_ID
import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApiService {

    @GET("photos")
    suspend fun getAllPhotos(@Query("client_id")
                             clientId: String = CLIENT_ID ): Response<List<GetPhotoListResponse>>

}