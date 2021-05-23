package com.gt.domain.usecase

import com.gt.domain.repository.SocialChannelRepository
import javax.inject.Inject

class SocialChannelUseCase @Inject constructor(private val socialChannelRepository: SocialChannelRepository) {
    //here in this class goes all the logic of business rules
    // and data transformation and flow will emit data which live data will collect and
    // then view model will handle presentation logic for it
}