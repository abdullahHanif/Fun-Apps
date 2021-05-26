package com.gt.domain.usecase

import com.gt.domain.common.Result
import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.entity.SocialChannelEntity
import com.gt.domain.entity.SocialItemEntity
import com.gt.domain.repository.SocialChannelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SocialChannelUseCaseImpl @Inject constructor(private val socialChannelRepository: SocialChannelRepository) :
    SocialChannelUseCase {
    // In this class goes all the logic of business rules
    // and data transformation and flow will emit data which live data will collect and
    // then view model will handle presentation logic for it

/*    override fun fetchSocialChannelDataFlow(
        fetchFromRemote: Boolean,
        appType: String
    ) = flow<SocialChannelEntity> {
        lateinit var data: Result<SocialChannelEntity>;

        if (fetchFromRemote) {
            //blocking call
            data = socialChannelRepository.getSocialChannels() as Result<SocialChannelEntity>
        } else {
            //blocking call
            data = socialChannelRepository.getSavedSocialChannels() as Result<SocialChannelEntity>
        }

        if (appType.equals("FREE", true)) {
            //business logic of data manipulations goes here.
        }

        //emit(data)
    }.flowOn(Dispatchers.IO)*/

    override fun fetchSocialDataFlow(
        fetchFromRemote: Boolean,
        appType: String
    ) = flow<List<SocialItemEntity>> {
        lateinit var data: List<SocialItemEntity>

        if (fetchFromRemote) {
            //blocking call
            socialChannelRepository.getSocialChannels().let {
                when (it) {
                    is Result.Success -> {
                        val list = it.data?.socialEntityList
                        emit(list!!)
                    }
                    is Result.Error -> {

                    }
                }
            }
        } else {
            //blocking call
            //data = socialChannelRepository.getSavedSocialChannels() as Result<SocialChannelEntity>
        }

        if (appType.equals("FREE", true)) {
            //business logic of data manipulations goes here.
        }

    }.flowOn(Dispatchers.IO)

    override fun fetchChannelDataFlow(
        fetchFromRemote: Boolean,
        appType: String
    ) = flow<List<ChannelItemEntity>> {
        lateinit var data: List<ChannelItemEntity>

        if (fetchFromRemote) {
            //blocking call
            socialChannelRepository.getSocialChannels().let {
                when (it) {
                    is Result.Success -> {
                        val list = it.data?.channelEntityList
                        emit(list!!)
                    }
                    is Result.Error -> {

                    }
                }
            }

        } else {
            //blocking call
            //data = socialChannelRepository.getSavedSocialChannels() as Result<SocialChannelEntity>
        }

        if (appType.equals("FREE", true)) {
            //business logic of data manipulations goes here.
        }

    }.flowOn(Dispatchers.IO)
}