package com.gt.funapps.view.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.gt.funapps.R
import com.gt.funapps.base.BaseActivity
import com.gt.funapps.databinding.ActivityMainBinding
import com.gt.funapps.view.adapters.HomePagerAdapter
import com.gt.funapps.view.view.fragments.ChannelFragment
import com.gt.funapps.view.view.fragments.SocialFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun showLoader() {
        binding.rootView.showLoader()
    }

    override fun hideLoader() {
        binding.rootView.hideLoader()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewPager()
    }

    private fun initViewPager() {
        //item in viewpager
        val fragmentList: MutableList<Fragment> = mutableListOf(
                SocialFragment(),
                ChannelFragment(),
            )

        val adapter = HomePagerAdapter(supportFragmentManager, lifecycle, fragmentList)
        binding.viewpager.adapter = adapter

        //adding two tabs in tab layout
        binding.tabLayout.addTab(tab_layout.newTab().setText(getString(R.string.social)))
        binding.tabLayout.addTab(tab_layout.newTab().setText(getString(R.string.channel)))

        //adding swipe for screen on tab selection
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem = tab?.position ?: 0
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {}

        })

        //adding swipe support for tabs
        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }
}