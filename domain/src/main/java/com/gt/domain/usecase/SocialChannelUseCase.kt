package com.gt.domain.usecase

import com.gt.domain.common.Result
import com.gt.domain.entity.SocialChannelEntity
import com.gt.domain.repository.SocialChannelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SocialChannelUseCase @Inject constructor(private val socialChannelRepository: SocialChannelRepository) {
    // In this class goes all the logic of business rules
    // and data transformation and flow will emit data which live data will collect and
    // then view model will handle presentation logic for it

    fun fetchSocialChannelDataFlow(
        fetchFromRemote: Boolean,
        appType: String
    ) = flow<Result<SocialChannelEntity>> {
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

        emit(data)
    }.flowOn(Dispatchers.IO)
}