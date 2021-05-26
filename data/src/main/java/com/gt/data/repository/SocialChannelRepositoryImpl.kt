package com.gt.data.repository

import com.gt.data.datasource.local.socialchannel.SocialChannelLocalDataSource
import com.gt.data.datasource.remote.network.socialchannel.SocialChannelRemoteDataSource
import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity
import com.gt.domain.repository.SocialChannelRepository
import javax.inject.Inject

class SocialChannelRepositoryImpl @Inject constructor(
    private val localDataSource: SocialChannelLocalDataSource,
    private val remoteDataSource: SocialChannelRemoteDataSource
) : SocialChannelRepository {

    override suspend fun getSocialChannels(): Result<SocialChannelEntity> = remoteDataSource.getSocialChannelList()

    override suspend fun getSavedSocialChannels(): Result<Any> = localDataSource.getSocialChannelList()

    override suspend fun deleteSavedSocialChannels() {
        TODO("Not yet implemented")
    }

}