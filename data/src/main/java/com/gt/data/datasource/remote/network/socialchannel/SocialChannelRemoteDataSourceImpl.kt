package com.gt.data.datasource.remote.network.socialchannel

import com.gt.data.datasource.remote.api.SocialChannelService
import com.gt.data.mapper.DataSocialChannelMapper
import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity
import javax.inject.Inject

class SocialChannelRemoteDataSourceImpl @Inject constructor(private val socialChannelService: SocialChannelService) : SocialChannelRemoteDataSource {
    override suspend fun getSocialChannelList(): Result<SocialChannelEntity> {
        val data: SocialChannelData = socialChannelService.getSocialChannels()

        return Result.Success(DataSocialChannelMapper.fromDataToDomainType(data))
    }


}