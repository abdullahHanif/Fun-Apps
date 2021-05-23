package com.gt.data.datasource.remote.network.socialchannel

import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result

interface SocialChannelRemoteDataSource {
    suspend fun getSocialChannelList(): Result<SocialChannelData>
}