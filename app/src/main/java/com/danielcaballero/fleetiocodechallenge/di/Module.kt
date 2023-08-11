package com.danielcaballero.fleetiocodechallenge.di

import android.util.Log
import com.danielcaballero.fleetiocodechallenge.common.BASE_URL
import com.danielcaballero.fleetiocodechallenge.domain.Repository
import com.danielcaballero.fleetiocodechallenge.domain.RepositoryImpl
import com.danielcaballero.fleetiocodechallenge.model.network.LocalDataSource
import com.danielcaballero.fleetiocodechallenge.model.network.LocalDataSourceImpl
import com.danielcaballero.fleetiocodechallenge.model.network.NetworkFleet
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(ViewModelComponent::class)
interface Module {

    @Binds
    fun provideLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource

    @Binds
    fun provideRepositoory(
        repositoryImpl: RepositoryImpl
    ): Repository

    companion object {


        @Provides
        fun provideExceptionHandler(): CoroutineExceptionHandler =
            CoroutineExceptionHandler { _, throwable ->
                Log.e("VehiclesInformationViewModel", throwable.toString())
            }

        @Provides
        fun provideService(): NetworkFleet =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build()
                .create(NetworkFleet::class.java)


        @Provides
        fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()


    }
}