package com.ayoolamasha.meterest.data.diPackage

import com.ayoolamasha.meterest.data.repositoryPackage.BaseRepository
import com.ayoolamasha.meterest.data.repositoryPackage.BaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {

    @Binds
    abstract fun providesBaseRepository(baseRepositoryImpl: BaseRepositoryImpl):BaseRepository
}