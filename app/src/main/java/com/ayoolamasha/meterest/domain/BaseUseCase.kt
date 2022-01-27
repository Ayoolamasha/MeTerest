package com.ayoolamasha.meterest.domain

import com.ayoolamasha.meterest.data.execptionPackage.Failure
import com.ayoolamasha.meterest.data.extensionsPackage.Either
import kotlinx.coroutines.*

abstract class BaseUseCase<out Type, in Params> where Type: Any {
    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult:(Either<Failure, Type>) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main){
            val deferred = async(Dispatchers.IO){
                run(params)
            }
            onResult(deferred.await())

        }

    }
    class None
}