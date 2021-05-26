package com.gt.domain.repository

import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity

interface SocialChannelRepository {
    suspend fun getSocialChannels(): Result<SocialChannelEntity>

    suspend fun deleteSavedSocialChannels()
}