package com.gt.data.mapper

import com.gt.data.model.SocialChannelData
import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.entity.SocialChannelEntity
import com.gt.domain.entity.SocialItemEntity

object DataSocialChannelMapper : Mapper<SocialChannelEntity, SocialChannelData> {
    override fun fromDataToDomainType(from: SocialChannelData): SocialChannelEntity {
        val domain = SocialChannelEntity()

        from.body.channels.forEach {
            domain.channelEntityList.add(
                ChannelItemEntity(
                    false,
                    it.iconUrl,
                    it.name,
                    it.packageNameAndroid,
                    it.url
                )
            )
        }

        from.body.socials.forEach {
            domain.socialEntityList.add(
                SocialItemEntity(
                    false,
                    it.iconUrl,
                    it.name,
                    it.packageNameAndroid,
                    it.url
                )
            )
        }

        return domain
    }

    override fun fromDomainToDataType(to: SocialChannelEntity): SocialChannelData {
        return SocialChannelData()
    }
}