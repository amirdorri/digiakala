package com.example.digikala.di

import android.content.Context
import com.example.digikala.data.datastore.DataStoreRepository
import com.example.digikala.data.datastore.DataStoreRepositoryImpl
import com.example.digikala.data.remote.HomeApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HomeApiInterfaceModule {

    @Provides
    @Singleton
    fun provideHomeApiService(retrofit: Retrofit) : HomeApiInterface =
        retrofit.create(HomeApiInterface::class.java)

}