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
import com.gt.funapps.databinding.FragmentSocialBinding
import com.gt.funapps.view.adapters.SocialItemListAdapter
import com.gt.funapps.view.viewmodel.FragmentSocialViewModel
import com.gt.funapps.view.viewmodel.SocialListEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SocialFragment : BaseFragment() {

    lateinit var binding: FragmentSocialBinding
    val viewmodel: FragmentSocialViewModel by viewModels()

    private lateinit var adapter: SocialItemListAdapter

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_social, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewmodel.obNavEvents.observe(viewLifecycleOwner, Observer {
            it.getEventIfNotHandled()?.let {
                when (it) {
                    is SocialListEvent.NotifyAdapter -> {
                        adapter.notifyDataSetChanged()
                        //no data found
                        if (it.list.isNullOrEmpty()) {
                            binding.NoDataMessage.visibility = View.VISIBLE
                        } else {
                            binding.NoDataMessage.visibility = View.GONE
                        }
                    }

                    is SocialListEvent.ShowLoader -> {
                        showLoader()
                    }

                    is SocialListEvent.HideLoader -> {
                        hideLoader()
                    }

                    is SocialListEvent.OpenItem -> {
                        if (it.socialItemEntity.isPremiumItem) {
                            Toast.makeText(context, "Sorry this item is premium", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            val packageName = it.socialItemEntity.packageNameAndroid
                            val url = it.socialItemEntity.url

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
        adapter = SocialItemListAdapter(viewmodel)

        binding.rvSocialItem.layoutManager = LinearLayoutManager(context)
        binding.rvSocialItem.adapter = adapter
    }
}