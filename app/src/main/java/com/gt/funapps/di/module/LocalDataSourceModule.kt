package com.gt.funapps.di.module

import com.gt.data.datasource.local.socialchannel.SocialChannelLocalDataSource
import com.gt.data.datasource.local.socialchannel.SocialChannelLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideLocalDataSource(socialChannelLocalDataSourceImpl: SocialChannelLocalDataSourceImpl): SocialChannelLocalDataSource

}