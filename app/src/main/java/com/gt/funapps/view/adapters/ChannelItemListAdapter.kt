package com.gt.funapps.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gt.funapps.R
import com.gt.funapps.databinding.LiChannelItemBinding
import com.gt.funapps.view.viewmodel.FragmentChannelViewModel

class ChannelItemListAdapter(val viewmodel: FragmentChannelViewModel) :
    RecyclerView.Adapter<ChannelItemListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LiChannelItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LiChannelItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.li_channel_item, parent, false
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