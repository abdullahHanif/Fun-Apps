package com.gt.domain.usecase

import com.gt.domain.common.Result
import com.gt.domain.entity.ChannelItemEntity
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

    override fun fetchSocialDataFlow(
        appType: String
    ) = flow<List<SocialItemEntity>> {
        //blocking call
        socialChannelRepository.getSocialChannels().let {
            when (it) {
                is Result.Success -> {
                    val list = it.data?.socialEntityList
                    if (appType.equals("FREE", true)) {
                        //business logic of data manipulations goes here.
                        list!!.mapIndexed { index, item ->
                            if (index < 4) {
                                item.isPremiumItem = true
                            }
                        }.toList()
                    }

                    emit(list!!)
                }
                is Result.Error -> {

                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun fetchChannelDataFlow(
        appType: String
    ) = flow<List<ChannelItemEntity>> {
        //blocking call
        socialChannelRepository.getSocialChannels().let {
            when (it) {
                is Result.Success -> {
                    val list = it.data?.channelEntityList

                    if (appType.equals("FREE", true)) {
                        //business logic of data manipulations goes here.
                        list!!.mapIndexed { index, item ->
                            if (index < 4) {
                                item.isPremiumItem = true
                            }
                        }.toList()
                    }

                    emit(list!!)
                }
                is Result.Error -> {

                }
            }
        }
    }.flowOn(Dispatchers.IO)
}