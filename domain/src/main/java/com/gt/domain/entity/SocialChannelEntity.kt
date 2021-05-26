package com.gt.domain.entity

data class SocialChannelEntity constructor(
    var socialEntityList: MutableList<SocialItemEntity> = mutableListOf(),
    var channelEntityList: MutableList<ChannelItemEntity> = mutableListOf()
)