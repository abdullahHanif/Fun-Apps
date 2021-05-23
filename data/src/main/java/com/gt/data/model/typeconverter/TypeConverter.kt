package com.gt.data.model.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gt.data.model.Channel
import com.gt.data.model.Social

class ChannelTypeConverter {
    @TypeConverter
    fun stringToList(json: String): List<Channel> {
        val gson = Gson()
        val type = object : TypeToken<List<Channel>>() {

        }.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun ListToString(list: List<Channel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Channel>>() {

        }.type
        return gson.toJson(list, type)
    }
}

class SocialTypeConverter {
    @TypeConverter
    fun stringToList(json: String): List<Social> {
        val gson = Gson()
        val type = object : TypeToken<List<Social>>() {

        }.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun ListToString(list: List<Social>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Social>>() {

        }.type
        return gson.toJson(list, type)
    }
}