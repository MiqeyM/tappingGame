package com.example.android.tappinggame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.tappinggame.database.ScoreEntry
import com.example.android.tappinggame.game.GameActivity
import com.example.android.tappinggame.game.GameConstants.GAME_RESULT_REQUEST
import com.example.android.tappinggame.recycler.ScoreAdapter
import com.example.android.tappinggame.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_main.*


class ScoreActivity : AppCompatActivity() {


    private lateinit var scoreViewModel: ScoreViewModel
    private val adapter = ScoreAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        scoreRecyclerView.adapter = adapter
        scoreRecyclerView.layoutManager = LinearLayoutManager(this)
        scoreRecyclerView.setHasFixedSize(true)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        scoreViewModel.allScores.observe(this, Observer { items -> items?.let { adapter.setScores(items) } })




        play_button.setOnClickListener {
            val scoreToBeat = scoreViewModel.getSmallestScore(adapter.getSmallestDisplayedScore())
            val intent = Intent(this, GameActivity::class.java).putExtra("scoreToBeat", scoreToBeat)
            startActivityForResult(intent, GAME_RESULT_REQUEST)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GAME_RESULT_REQUEST && resultCode == Activity.RESULT_OK) {
            scoreViewModel.insert(ScoreEntry(0, data!!.getIntExtra("score", 0), data.getLongExtra("time", 0L)))


        }
    }
}
