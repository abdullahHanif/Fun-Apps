package com.gt.domain.entity

import java.io.Serializable

data class ChannelItemEntity(
    var isPremiumItem: Boolean,
    var iconUrl: String = "",
    var name: String = "",
    var packageNameAndroid: String = "",
    var url: String = ""
) : Serializable