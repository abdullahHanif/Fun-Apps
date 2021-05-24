package com.gt.domain.entity

data class SocialChannelEntity constructor(
    var socialEntityList: List<SocialItemEntity> = listOf(),
    var channelEntityList: List<ChannelItemEntity> = listOf()
)