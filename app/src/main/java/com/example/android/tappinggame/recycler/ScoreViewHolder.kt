package com.example.android.tappinggame.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.database.ScoreEntry
import kotlinx.android.synthetic.main.viewholder_score.view.*
import java.text.SimpleDateFormat
import java.util.*

class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  fun bind(newScore: ScoreEntry) = with(itemView) {
      scoreTextView.text = newScore.points.toString()

      timeTextView.text = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(Date(newScore.timeStamp))


    }

}
