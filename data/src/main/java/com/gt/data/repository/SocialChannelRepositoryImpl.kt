package com.gt.data.repository

import com.gt.data.datasource.local.socialchannel.SocialChannelLocalDataSource
import com.gt.data.datasource.remote.api.SocialChannelService
import com.gt.data.datasource.remote.network.socialchannel.SocialChannelRemoteDataSource
import com.gt.domain.common.Result
import com.gt.domain.repository.SocialChannelRepository
import javax.inject.Inject

class SocialChannelRepositoryImpl @Inject constructor(
    val service: SocialChannelService,
    val localDataSource: SocialChannelLocalDataSource,
    val remoteDataSource: SocialChannelRemoteDataSource
) : SocialChannelRepository {

    override suspend fun getSocialChannels(): Result<Any> = remoteDataSource.getSocialChannelList()

    override suspend fun getSavedSocialChannels(): Result<Any> =
        localDataSource.getSocialChannelList()

    override suspend fun deleteSavedSocialChannels() {
        TODO("Not yet implemented")
    }

}