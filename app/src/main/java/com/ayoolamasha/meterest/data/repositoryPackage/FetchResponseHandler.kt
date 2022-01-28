package com.ayoolamasha.meterest.data.repositoryPackage

import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.extensionsPackage.Either
import retrofit2.Response
import java.io.IOException


/**
 * FETCH, SAVE AND RETRIEVE FROM DB
 *
 */
fun<T, R> request(
    response:Response<T>,
    default: T,
    saveToDb : (T) -> Any,
    fetchFromDb: () -> R
):Either<Failure, R>{
    return try {
        when (response.isSuccessful) {
            true ->{
                saveToDb(response.body() ?: default)
                Either.RightSuccess(fetchFromDb())
            }
            false -> Either.LeftFailure(Failure.ServerError)
        }
    }catch (exception:Throwable){
        Either.LeftFailure(Failure.ServerError)
    }
}

/**
 * FETCH ONLY
 *
 */
fun<T, R> request(
    response:Response<T>,
    transform:(T) -> R,
    default: T
):Either<Failure, R>{

    return try {
        when(response.isSuccessful){
            true -> Either.RightSuccess(transform(response.body() ?: default))
            false -> Either.LeftFailure(Failure.ServerError)
        }
    }catch (exception:Throwable){
        Either.LeftFailure(Failure.ServerError)
    }


}




