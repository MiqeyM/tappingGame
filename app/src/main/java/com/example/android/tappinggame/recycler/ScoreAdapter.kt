package com.example.android.tappinggame.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.R
import com.example.android.tappinggame.database.ScoreEntry

class ScoreAdapter : RecyclerView.Adapter<ScoreViewHolder>(){

    private var items:List<ScoreEntry> = emptyList()
        set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun getItemCount(): Int = Math.min(items.size, MAX_DISPLAYED_RECORDS)

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) = holder.bind(items[position])

    fun setScores(scores: List<ScoreEntry>){
        this.items = scores
        notifyDataSetChanged()
    }

    companion object{
        private val MAX_DISPLAYED_RECORDS = 5;
    }


}