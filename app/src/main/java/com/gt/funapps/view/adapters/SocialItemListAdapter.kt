package com.gt.funapps.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gt.funapps.R
import com.gt.funapps.databinding.LiSocialItemBinding
import com.gt.funapps.view.viewmodel.FragmentSocialViewModel

class SocialItemListAdapter(val viewmodel: FragmentSocialViewModel) :
    RecyclerView.Adapter<SocialItemListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LiSocialItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LiSocialItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.li_social_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = viewmodel.list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = viewmodel.list[position]
        holder.binding.viewmodel = viewmodel

        holder.binding.rootView.setOnClickListener {
            viewmodel.onItemClicked(viewmodel.list[position])
        }

        holder.binding.executePendingBindings()
    }

}