package com.gt.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gt.data.db.entity.SocialChannelEntity

@Dao
interface SocialChannelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(socialChannel: SocialChannelEntity): Long

    @Query("SELECT * FROM SocialChannelEntity")
    suspend fun get(): List<SocialChannelEntity>
}