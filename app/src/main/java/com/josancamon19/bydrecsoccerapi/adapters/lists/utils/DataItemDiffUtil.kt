package com.josancamon19.bydrecsoccerapi.adapters.lists.utils

import androidx.recyclerview.widget.DiffUtil
import com.josancamon19.bydrecsoccerapi.models.DataItem


class DataItemDiffUtil : DiffUtil.ItemCallback<DataItem>() {
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}