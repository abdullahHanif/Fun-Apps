package com.gt.data.datasource.remote.network.socialchannel

import com.gt.data.datasource.remote.api.SocialChannelService
import com.gt.data.datasource.remote.network.RemoteSource
import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result
import javax.inject.Inject

class SocialChannelRemoteDataSourceImpl @Inject constructor(private val socialChannelService: SocialChannelService) :
    RemoteSource(),
    SocialChannelRemoteDataSource {
    override suspend fun getSocialChannelList(): Result<SocialChannelData> {
        val data: SocialChannelData = socialChannelService.getSocialChannels()
        print("hhhhh" + data)
        return Result.Success(data)
    }


}