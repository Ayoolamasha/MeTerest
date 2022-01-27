package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.extensionsPackage.Either
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import com.ayoolamasha.meterest.domain.PhotoUICase

interface BaseRepository {
   suspend fun getPhotos(): Either<Failure, List<PhotoUICase>>

}