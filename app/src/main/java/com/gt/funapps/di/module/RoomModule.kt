package com.gt.funapps.di.module

import android.content.Context
import androidx.room.Room
import com.gt.data.db.FunAppsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): FunAppsDatabase =
        Room.databaseBuilder(context, FunAppsDatabase::class.java, FunAppsDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideSocialChannelDao(db: FunAppsDatabase) = db.socialChannelDao()

}