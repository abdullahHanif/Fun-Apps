package com.gt.funapps.view.viewmodel

import androidx.lifecycle.ViewModel
import com.gt.domain.entity.SocialItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentSocialViewModel @Inject constructor() : ViewModel() {
    var list: MutableList<SocialItemEntity> = mutableListOf()

    fun onItemClicked(any: Any) {
        TODO("Not yet implemented")
    }

}