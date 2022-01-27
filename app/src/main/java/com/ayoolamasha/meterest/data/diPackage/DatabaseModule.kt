package com.ayoolamasha.meterest.data.diPackage

import android.content.Context
import androidx.room.Room
import com.ayoolamasha.meterest.data.PHOTOS_TABLE
import com.ayoolamasha.meterest.data.roomPackage.PhotosRoomDataBase
import com.ayoolamasha.meterest.data.roomPackage.dao.PhotosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private lateinit var photosRoomDataBase: PhotosRoomDataBase
    private const val DATABASE_NAME = PHOTOS_TABLE

    @Singleton
    @Provides
    fun providesRoomDataBase(@ApplicationContext context: Context):PhotosRoomDataBase{
        photosRoomDataBase = Room.databaseBuilder(
            context, PhotosRoomDataBase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()

        return photosRoomDataBase
    }

    @Singleton
    @Provides
    fun providesPhotoRoomDao(photosRoomDataBase: PhotosRoomDataBase): PhotosDao{
        return photosRoomDataBase.photosDao()
    }
}