package com.gt.funapps.view.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gt.funapps.R
import com.gt.funapps.base.BaseFragment
import com.gt.funapps.databinding.FragmentChannelBinding
import com.gt.funapps.view.viewmodel.FragmentChannelViewModel

class ChannelFragment : BaseFragment() {
    lateinit var binding: FragmentChannelBinding
    val viewmodel: FragmentChannelViewModel by viewModels()

    override fun showLoader() {
        binding.rootView.showLoader()
    }

    override fun hideLoader() {
        binding.rootView.hideLoader()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_channel, container, false)
        return binding.root
    }
}