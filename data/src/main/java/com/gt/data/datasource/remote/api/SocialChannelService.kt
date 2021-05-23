package com.gt.data.datasource.remote.api

import com.gt.data.model.SocialChannelData
import retrofit2.http.GET

interface SocialChannelService {
    @GET("premium/channels-socials.json")
    suspend fun getSocialChannels(): SocialChannelData

}