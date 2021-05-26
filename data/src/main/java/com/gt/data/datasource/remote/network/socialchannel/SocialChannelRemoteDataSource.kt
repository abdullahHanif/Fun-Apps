package com.gt.data.datasource.remote.network.socialchannel

import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity

interface SocialChannelRemoteDataSource {
    suspend fun getSocialChannelList(): Result<SocialChannelEntity>
}