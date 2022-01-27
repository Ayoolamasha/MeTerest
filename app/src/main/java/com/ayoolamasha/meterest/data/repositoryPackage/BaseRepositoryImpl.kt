package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.apiPackage.PhotoApiServiceHelper
import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.extensionsPackage.Either
import com.ayoolamasha.meterest.data.roomPackage.PhotosEntity
import com.ayoolamasha.meterest.data.roomPackage.PhotosRoomDataBase
import com.ayoolamasha.meterest.domain.PhotoUICase
import com.ayoolamasha.meterest.utlis.NetworkHelper
import retrofit2.Response
import javax.inject.Inject

class BaseRepositoryImpl @Inject constructor(
    private val photoApiServiceHelper: PhotoApiServiceHelper,
    private val networkHelper: NetworkHelper,
    private val photosRoomDataBase: PhotosRoomDataBase
): BaseRepository {


    override suspend fun getPhotos(): Either<Failure, List<PhotoUICase>> {
        return when(networkHelper.isNetworkAvailable()){
            true -> request(
                photoApiServiceHelper.getAllPhotos(),{
                    it.map{photosList ->  photosList.toPhotoUiCase()}} ,
                emptyList()

            )
            false -> Either.LeftFailure(Failure.NetworkConnection)
        }
    }

//    override suspend fun saveToDB(photosEntity: List<PhotosEntity>) {
//        photosRoomDataBase.photosDao().clearAndInsertRoomPhotos(photosEntity)
//    }


    private fun<T, R> request(
        response:Response<T>,
        transform: (T) -> R,
        default: T
    ):Either<Failure, R>{
        return try {
            when (response.isSuccessful) {
                true -> Either.RightSuccess(transform(response.body() ?: default))
                false -> Either.LeftFailure(Failure.ServerError)
            }
        }catch (exception:Throwable){
            Either.LeftFailure(Failure.ServerError)
        }
    }

}

