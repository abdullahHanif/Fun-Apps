package com.gt.domain.usecase

import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.entity.SocialItemEntity
import kotlinx.coroutines.flow.Flow

interface SocialChannelUseCase {
    fun fetchSocialDataFlow(
        appType: String
    ): Flow<List<SocialItemEntity>>

    fun fetchChannelDataFlow(
        appType: String
    ): Flow<List<ChannelItemEntity>>
}