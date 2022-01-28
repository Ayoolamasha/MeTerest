package com.ayoolamasha.meterest.data.apiPackage

import com.ayoolamasha.meterest.data.CLIENT_ID
import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApiService {

    @GET("photos")
    suspend fun getAllPhotos(@Query("client_id")
                             clientId: String = CLIENT_ID): Response<List<GetPhotoListResponse>>

    @GET("photos")
    suspend fun getAllPhotosPaging(@Query("client_id")
                             clientId: String = CLIENT_ID,
                             @Query("page") page: Int?,
                             @Query("per_page") perPage: Int?,
                             @Query("order_by") order_by:String?): Response<List<GetPhotoListResponse>>

}