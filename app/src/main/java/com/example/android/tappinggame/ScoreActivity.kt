package com.example.android.tappinggame

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tappinggame.database.ScoreEntry
import com.example.android.tappinggame.game.GameActivity
import com.example.android.tappinggame.recycler.ScoreAdapter
import com.example.android.tappinggame.viewmodel.ScoreViewModel


class ScoreActivity : AppCompatActivity() {

   companion object{
       const val GAME_RESULT_REQUEST = 1  // The request code

   }


    private lateinit var scoreViewModel: ScoreViewModel
    private val adapter = ScoreAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.score_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        scoreViewModel.allScores.observe(this, Observer { items -> items?.let { adapter.setScores(items) } })

        val playButton = findViewById<Button>(R.id.play_button)

        playButton.setOnClickListener { startActivityForResult(Intent(this, GameActivity::class.java),
            GAME_RESULT_REQUEST) }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GAME_RESULT_REQUEST && resultCode == Activity.RESULT_OK) {
           scoreViewModel.insert(ScoreEntry(0,data!!.getIntExtra("score",0),data.getLongExtra("time",0L)))


        }
    }
}
