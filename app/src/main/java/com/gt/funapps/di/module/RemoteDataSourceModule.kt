package com.gt.funapps.di.module

import com.gt.data.datasource.remote.network.socialchannel.SocialChannelRemoteDataSource
import com.gt.data.datasource.remote.network.socialchannel.SocialChannelRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(socialChannelRemoteDataSourceImpl: SocialChannelRemoteDataSourceImpl): SocialChannelRemoteDataSource

}