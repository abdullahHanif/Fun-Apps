package com.gt.data.datasource.local.socialchannel

import com.gt.data.db.dao.SocialChannelDao
import com.gt.data.mapper.DataSocialChannelMapper
import com.gt.data.model.SocialChannelData
import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SocialChannelLocalDataSourceImpl @Inject constructor(private val socialChannelDao: SocialChannelDao) :
 SocialChannelLocalDataSource {

    override suspend fun getSocialChannelList(): Result<SocialChannelEntity> {
        return try {
            val data = socialChannelDao.getAll()
            Result.Success(DataSocialChannelMapper.fromDataToDomainType(data))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun saveAll(data: SocialChannelData) {
        socialChannelDao.insert(data)
    }

    override suspend fun deleteAll() {
        socialChannelDao.truncate()
    }
}