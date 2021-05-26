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

    override suspend fun getSocialChannels(): Result<SocialChannelEntity> {
        val data = remoteDataSource.getSocialChannelList()

        when (data) {
            is Result.Success -> {
                localDataSource.deleteAll()
                localDataSource.saveAll(data.data!!)
            }
        }

        return localDataSource.getSocialChannelList()
    }

    override suspend fun deleteSavedSocialChannels() {
        localDataSource.deleteAll()
    }

}