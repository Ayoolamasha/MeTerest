package com.ayoolamasha.meterest.data.diPackage


import com.ayoolamasha.meterest.BuildConfig
import com.ayoolamasha.meterest.data.BASE_URL_STRING
import com.ayoolamasha.meterest.data.apiPackage.PhotoApiService
import com.ayoolamasha.meterest.data.apiPackage.PhotoApiServiceHelper
import com.ayoolamasha.meterest.data.apiPackage.PhotoApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiHelper(photoApiServiceImpl: PhotoApiServiceImpl): PhotoApiServiceHelper{
        return photoApiServiceImpl
    }


    private const val BASE_URL : String = BASE_URL_STRING


    @Provides
    fun providesBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun providesOkHttpClient() = if (BuildConfig.DEBUG){
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(logging)
            .build()
    }else OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): PhotoApiService = retrofit.create(PhotoApiService::class.java)

}