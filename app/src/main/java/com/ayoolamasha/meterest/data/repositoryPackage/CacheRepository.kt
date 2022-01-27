package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.responsePackage.GetPhotoListResponse
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import com.ayoolamasha.meterest.domain.PhotoUICase

interface CacheRepository {
    fun saveToDB(photosEntity: List<GetPhotoListResponse>)
    fun fetchFromDB(): List<PhotoUICase>
}