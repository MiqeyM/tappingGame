package com.example.android.tappinggame.game

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.android.tappinggame.R
import com.example.android.tappinggame.game.GameConstants.GAME_TIME
import com.example.android.tappinggame.game.GameConstants.WARMUP_TIME
import com.example.android.tappinggame.model.Score
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var currentScore = 0
    private var gameTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val timerWarmUp = Timer(counter_text_view, WARMUP_TIME) { startGame() }
        timerWarmUp.start()



    }

    private fun finishGame() {

        gameView.setOnClickListener {  }

        val newScore = Intent().putExtra("score", currentScore).putExtra("time",gameTime)
        setResult(Activity.RESULT_OK, newScore)
        finish()

        return

    }


    private fun startGame() {
        counter_text_view.visibility = View.GONE
        points_text_view.visibility = View.VISIBLE
        timer_text_view.visibility = View.VISIBLE
        points_text_view.setText(currentScore.toString())
        gameTime = System.currentTimeMillis()
        gameView.setOnClickListener {
            currentScore++
            points_text_view.setText(currentScore.toString())

        }

        val timerGameTime = Timer(timer_text_view, GAME_TIME) { finishGame() }
        timerGameTime.start()

        return


    }
}
