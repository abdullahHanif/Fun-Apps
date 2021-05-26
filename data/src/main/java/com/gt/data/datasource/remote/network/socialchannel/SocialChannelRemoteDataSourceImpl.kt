package com.gt.data.datasource.remote.network.socialchannel

import com.gt.data.datasource.remote.api.SocialChannelService
import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result
import javax.inject.Inject

class SocialChannelRemoteDataSourceImpl @Inject constructor(private val socialChannelService: SocialChannelService) :
    SocialChannelRemoteDataSource {
    override suspend fun getSocialChannelList(): Result<SocialChannelData> {
        return try {
            Result.Success(socialChannelService.getSocialChannels())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}