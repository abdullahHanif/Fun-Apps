package com.gt.funapps.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.usecase.SocialChannelUseCase
import com.gt.funapps.BuildConfig
import com.gt.funapps.base.BaseEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentChannelViewModel @Inject constructor(private val socialChannelUseCase: SocialChannelUseCase) :
    ViewModel() {
    var list: List<ChannelItemEntity> = mutableListOf()

    private var navEvents: MutableLiveData<BaseEvent<ChannelListEvent>> = MutableLiveData()
    val obNavEvents: LiveData<BaseEvent<ChannelListEvent>> = navEvents

    init {
        navEvents.value = BaseEvent(ChannelListEvent.ShowLoader)
        fetchChannelList()
    }

    private fun fetchChannelList() {
        viewModelScope.launch {

            socialChannelUseCase.fetchChannelDataFlow(true, BuildConfig.APP_TYPE).collect {
                list = it

                navEvents.value = BaseEvent(ChannelListEvent.HideLoader)
                navEvents.value = BaseEvent(ChannelListEvent.NotifyAdapter(list))

            }
        }
    }


    fun onItemClicked(channelItemEntity: ChannelItemEntity) {
        navEvents.value = BaseEvent(ChannelListEvent.OpenItem(channelItemEntity))
    }

}

sealed class ChannelListEvent {
    class NotifyAdapter(val list: List<ChannelItemEntity>) : ChannelListEvent()
    class OpenItem(val channelItemEntity: ChannelItemEntity) : ChannelListEvent()
    object ShowLoader : ChannelListEvent()
    object HideLoader : ChannelListEvent()
}