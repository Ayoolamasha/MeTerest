package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.extensionsPackage.Either
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import com.ayoolamasha.meterest.domain.BaseUseCase
import com.ayoolamasha.meterest.domain.PhotoUICase
import javax.inject.Inject

class GetAllPhotos @Inject constructor(private val baseRepository: BaseRepository): BaseUseCase<List<PhotoUICase>, BaseUseCase.None>(){
    override suspend fun run(params: None): Either<Failure, List<PhotoUICase>> {
        return baseRepository.getPhotos()
    }

}