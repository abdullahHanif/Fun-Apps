package com.gt.data.datasource.local.socialchannel

import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity

interface SocialChannelLocalDataSource {
    suspend fun getSocialChannelList(): Result<SocialChannelEntity>

    suspend fun saveAll(data: SocialChannelData)

    suspend fun deleteAll()
}