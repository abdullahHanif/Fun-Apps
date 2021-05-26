package com.gt.data.model

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.gt.data.model.typeconverter.ChannelTypeConverter
import com.gt.data.model.typeconverter.SocialTypeConverter
import java.io.Serializable

@Entity
@TypeConverters(ChannelTypeConverter::class)
data class SocialChannelData(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = -1,

    @Embedded
    @SerializedName("body")
    var body: Body = Body()
) : BaseModel(), Serializable

@Entity
@TypeConverters(SocialTypeConverter::class)
data class Body(
    @SerializedName("channels")
    @ColumnInfo(name = "channels")
    var channels: MutableList<Channel> = mutableListOf(),

    @ColumnInfo(name = "socials")
    @SerializedName("socials")
    var socials: MutableList<Social> = mutableListOf()
) : Serializable

@Entity
data class Channel(
    @SerializedName("icon_url")
    @ColumnInfo(name = "iconUrl")
    var iconUrl: String = "",

    @PrimaryKey
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String = "",

    @SerializedName("package_name_android")
    @ColumnInfo(name = "packageNameAndroid")
    var packageNameAndroid: String = "",

    @SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String = ""
) : Serializable

@Entity
data class Social(

    @SerializedName("icon_url")
    @ColumnInfo(name = "iconUrl")
    var iconUrl: String = "",

    @PrimaryKey
    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String = "",

    @ColumnInfo(name = "packageNameAndroid")
    @SerializedName("package_name_android")
    var packageNameAndroid: String = "",

    @ColumnInfo(name = "url")
    @SerializedName("url")
    var url: String = ""
) : Serializable

