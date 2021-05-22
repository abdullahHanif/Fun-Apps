package com.gt.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class SocialChannelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Long = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "url")
    var url: String = "",
    @ColumnInfo(name = "icon_url")
    var icon_url: String = "",
    @ColumnInfo(name = "package_name_android")
    var package_name_android: String = ""
) : Serializable