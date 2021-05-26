package com.gt.funapps.view.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gt.funapps.R
import com.gt.funapps.base.BaseFragment
import com.gt.funapps.databinding.FragmentChannelBinding
import com.gt.funapps.view.adapters.ChannelItemListAdapter
import com.gt.funapps.view.viewmodel.ChannelListEvent
import com.gt.funapps.view.viewmodel.FragmentChannelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChannelFragment : BaseFragment() {

    private lateinit var adapter: ChannelItemListAdapter
    private lateinit var binding: FragmentChannelBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewmodel.obNavEvents.observe(viewLifecycleOwner, Observer {
            it.getEventIfNotHandled()?.let {
                when (it) {
                    is ChannelListEvent.NotifyAdapter -> {
                        adapter.notifyDataSetChanged()
                        //no data found
                        if (it.list.isNullOrEmpty()) {
                            binding.NoDataMessage.visibility = View.VISIBLE
                        } else {
                            binding.NoDataMessage.visibility = View.GONE
                        }
                    }

                    is ChannelListEvent.ShowLoader -> {
                        showLoader()
                    }

                    is ChannelListEvent.HideLoader -> {
                        hideLoader()
                    }

                    is ChannelListEvent.OpenItem -> {
                        if (it.channelItemEntity.isPremiumItem) {
                            Toast.makeText(context, "Sorry this item is premium", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            val packageName = it.channelItemEntity.packageNameAndroid
                            val url = it.channelItemEntity.url

                            val intent: Intent =
                                context?.packageManager?.getLaunchIntentForPackage(packageName)
                                    ?: Intent(Intent.ACTION_VIEW, Uri.parse(url));

                            startActivity(intent)
                        }
                    }
                }
            }
        })
    }

    private fun initAdapter() {
        adapter = ChannelItemListAdapter(viewmodel)

        binding.rvChannelItem.layoutManager = LinearLayoutManager(context)
        binding.rvChannelItem.adapter = adapter
    }
}