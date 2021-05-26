package com.gt.funapps.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gt.domain.entity.SocialItemEntity
import com.gt.domain.usecase.SocialChannelUseCase
import com.gt.funapps.BuildConfig
import com.gt.funapps.base.BaseEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentSocialViewModel @Inject constructor(private val socialChannelUseCase: SocialChannelUseCase) :
    ViewModel() {
    var list: List<SocialItemEntity> = mutableListOf()

    private var navEvents: MutableLiveData<BaseEvent<SocialListEvent>> = MutableLiveData()
    val obNavEvents: LiveData<BaseEvent<SocialListEvent>> = navEvents

    init {
        navEvents.value = BaseEvent(SocialListEvent.ShowLoader)
        fetchSocialList()
    }

    private fun fetchSocialList() {
        viewModelScope.launch {

            socialChannelUseCase.fetchSocialDataFlow(true, BuildConfig.APP_TYPE).collect {
                list = it

                navEvents.value = BaseEvent(SocialListEvent.HideLoader)
                navEvents.value = BaseEvent(SocialListEvent.NotifyAdapter(list))

            }
        }
    }


    fun onItemClicked(socialItemEntity: SocialItemEntity) {
        navEvents.value = BaseEvent(SocialListEvent.OpenItem(socialItemEntity))
    }

}

sealed class SocialListEvent {
    class NotifyAdapter(val list: List<SocialItemEntity>) : SocialListEvent()
    class OpenItem(val socialItemEntity: SocialItemEntity) : SocialListEvent()
    object ShowLoader : SocialListEvent()
    object HideLoader : SocialListEvent()
}