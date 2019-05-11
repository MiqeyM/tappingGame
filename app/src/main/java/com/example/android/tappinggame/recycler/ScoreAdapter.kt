package com.example.android.tappinggame.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.R
import com.example.android.tappinggame.entity.ScoreEntry

class ScoreAdapter : RecyclerView.Adapter<ScoreViewHolder>(){

    var items:List<ScoreEntry> = emptyList<ScoreEntry>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) = holder.bind(items[position])
}