package com.josancamon19.bydrecsoccerapi.adapters

import androidx.recyclerview.widget.DiffUtil
import com.josancamon19.bydrecsoccerapi.models.Match

class MatchDiffUtil : DiffUtil.ItemCallback<Match>() {
    override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem == newItem
    }
}