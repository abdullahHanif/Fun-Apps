package com.gt.funapps.di.module

import com.gt.domain.usecase.SocialChannelUseCase
import com.gt.domain.usecase.SocialChannelUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun provideSocialChannelUseCase(socialChannelUseCaseImpl: SocialChannelUseCaseImpl): SocialChannelUseCase
}