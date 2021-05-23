package com.gt.data.mapper

import com.gt.data.model.SocialChannelData

object DataSocialChannelMapper : Mapper<SocialChannelData, String> {

    override fun fromDataToDomainType(from: String): SocialChannelData {
        return SocialChannelData()
    }

    override fun fromDomainToDataType(to: SocialChannelData): String {
        return ""
    }
}