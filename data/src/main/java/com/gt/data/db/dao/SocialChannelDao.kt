package com.gt.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gt.data.model.SocialChannelData

@Dao
interface SocialChannelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(socialChannel: SocialChannelData): Long

    @Query("SELECT * FROM SocialChannelData")
    suspend fun getAll(): SocialChannelData

    @Query("Delete FROM SocialChannelData")
    suspend fun truncate()
}