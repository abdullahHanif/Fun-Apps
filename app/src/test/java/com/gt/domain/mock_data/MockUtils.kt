package com.gt.domain.mock_data

import androidx.annotation.WorkerThread
import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.entity.SocialItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object MockUtil {

    fun mockSocialList() = listOf(mockSocialItem())

    fun mockChannelList() = listOf(mockChannelItem())

    private fun mockSocialItem(): SocialItemEntity {
        return SocialItemEntity(
            false,
            "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
            "gooooogle",
            "",
            "https://www.google.com/"
        )
    }

    private fun mockChannelItem(): ChannelItemEntity {
        return ChannelItemEntity(
            false,
            "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
            "gooooogle",
            "",
            "https://www.google.com/"
        )
    }

    @WorkerThread
    fun getMockSocialFlow(): Flow<List<SocialItemEntity>> = flow<List<SocialItemEntity>> {
        emit(mockSocialList())
    }

}