package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.apiPackage.PhotoApiServiceHelper
import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.extensionsPackage.Either
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import com.ayoolamasha.meterest.data.roomPackage.PhotosRoomDataBase
import com.ayoolamasha.meterest.domain.PhotoUICase
import com.ayoolamasha.meterest.utlis.NetworkHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class BaseRepositoryImpl @Inject constructor(
    private val photoApiServiceHelper: PhotoApiServiceHelper,
    private val networkHelper: NetworkHelper,
    private val cacheRepository: CacheRepository
): BaseRepository {


    override suspend fun getPhotos(): Either<Failure, List<PhotoUICase>> {
        return when(networkHelper.isNetworkAvailable()){
            true -> request(
                photoApiServiceHelper.getAllPhotos(),
                emptyList(),
                {cacheRepository.saveToDB(it)},
                { cacheRepository.fetchFromDB()}
            )
            false -> Either.LeftFailure(Failure.NetworkConnection)
        }
    }




}

