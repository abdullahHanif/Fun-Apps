package com.gt.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
open class BaseModel(
    @Embedded
    @SerializedName("header")
    var header: Header = Header()
) : Serializable

data class Header(
    @SerializedName("code")
    @ColumnInfo(name = "code")
    var code: Int = 0,

    @SerializedName("message")
    @ColumnInfo(name = "message")
    var message: String = ""
): Serializable

