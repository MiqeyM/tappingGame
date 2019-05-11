package com.example.android.tappinggame.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.entity.ScoreEntry
import kotlinx.android.synthetic.main.viewholder_score.view.*

class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(newScore: ScoreEntry) = with(itemView) {
        score_text_view.text = newScore.points.toString()
        time_text_view.text = newScore.timeStamp.toString()
    }

}
