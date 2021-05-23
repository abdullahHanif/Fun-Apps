package com.gt.data.datasource.local.socialchannel

import com.gt.data.datasource.local.LocalSource
import com.gt.data.db.dao.SocialChannelDao
import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SocialChannelLocalDataSourceImpl @Inject constructor(private val socialChannelDao: SocialChannelDao) :
    LocalSource(), SocialChannelLocalDataSource {

    override suspend fun getSocialChannelList(): Result<SocialChannelData> {
        return try {
            val data = socialChannelDao.getAll()
            Result.Success(data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}