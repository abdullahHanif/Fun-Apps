package com.gt.data.datasource.local.socialchannel

import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result

interface SocialChannelLocalDataSource {
    suspend fun getSocialChannelList(): Result<SocialChannelData>
}