package com.gt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gt.data.db.dao.SocialChannelDao
import com.gt.data.db.entity.SocialChannelEntity

@Database(entities = [SocialChannelEntity::class], version = 1, exportSchema = false)
abstract class FunAppsDatabase : RoomDatabase() {
    abstract fun socialChannelDao(): SocialChannelDao

    companion object{
        val DATABASE_NAME: String = "fun_apps_db"
    }
}