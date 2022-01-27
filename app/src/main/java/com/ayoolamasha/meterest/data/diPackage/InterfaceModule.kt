package com.ayoolamasha.meterest.data.diPackage

import com.ayoolamasha.meterest.data.repositoryPackage.BaseRepository
import com.ayoolamasha.meterest.data.repositoryPackage.BaseRepositoryImpl
import com.ayoolamasha.meterest.data.repositoryPackage.CacheRepository
import com.ayoolamasha.meterest.data.repositoryPackage.CacheRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {

    @Binds
    abstract fun providesBaseRepository(baseRepositoryImpl: BaseRepositoryImpl):BaseRepository

    @Binds
    abstract fun providesCacheRepository(cacheRepositoryImpl: CacheRepositoryImpl):CacheRepository
}