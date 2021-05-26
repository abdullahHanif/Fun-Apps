package com.gt.funapps.di.module

import com.gt.data.repository.SocialChannelRepositoryImpl
import com.gt.domain.repository.SocialChannelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(socialChannelRepositoryImpl: SocialChannelRepositoryImpl): SocialChannelRepository

}