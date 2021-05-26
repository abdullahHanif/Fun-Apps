package com.gt.domain.usecase

import com.gt.domain.common.Result
import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.entity.SocialChannelEntity
import com.gt.domain.entity.SocialItemEntity
import kotlinx.coroutines.flow.Flow

interface SocialChannelUseCase {
//    fun fetchSocialChannelDataFlow(
//        fetchFromRemote: Boolean,
//        appType: String
//    ): Flow<SocialChannelEntity>

    fun fetchSocialDataFlow(
        fetchFromRemote: Boolean,
        appType: String
    ): Flow<List<SocialItemEntity>>

    fun fetchChannelDataFlow(
        fetchFromRemote: Boolean,
        appType: String
    ): Flow<List<ChannelItemEntity>>
}