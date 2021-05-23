package com.gt.domain.repository

import com.gt.domain.common.Result

interface SocialChannelRepository {
    suspend fun getSocialChannels(): Result<Any>

    suspend fun getSavedSocialChannels(): Result<Any>

    suspend fun deleteSavedSocialChannels()
}