package com.gt.funapps.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gt.domain.entity.ChannelItemEntity
import com.gt.domain.usecase.SocialChannelUseCase
import com.gt.funapps.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentChannelViewModel @Inject constructor(val socialChannelUseCase: SocialChannelUseCase) :
    ViewModel() {
    var list = MutableLiveData<List<ChannelItemEntity>>()


    init {
        fetchChannelList()
    }

    private fun fetchChannelList() {
        viewModelScope.launch {
            socialChannelUseCase.fetchChannelDataFlow(true, BuildConfig.APP_TYPE).collect {
                list.value = it
            }
        }
    }


    fun onItemClicked(any: Any) {
        TODO("Not yet implemented")
    }

}