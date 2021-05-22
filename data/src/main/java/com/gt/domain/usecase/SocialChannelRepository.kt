package com.gt.domain.usecase
import com.gt.data.common.Result

interface  SocialChannelRepository {
    suspend fun getSocialChannels(): Result<Any>
}