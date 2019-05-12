package com.example.android.tappinggame.game

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.android.tappinggame.R
import com.example.android.tappinggame.game.GameConstants.GAME_TIME
import com.example.android.tappinggame.game.GameConstants.WARMUP_TIME
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var currentScore = 0
    private var gameTime = 0L
    private var scoreToBeat = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        scoreToBeat = intent.getIntExtra("scoreToBeat", 0)
        val timerWarmUp = Timer(counterTextView, WARMUP_TIME) { startGame() }
        timerWarmUp.start()


    }

    private fun finishGame() {

        gameView.setOnClickListener { }
        val newScore = Intent().putExtra("score", currentScore).putExtra("time", gameTime)
        setResult(Activity.RESULT_OK, newScore)
        openDialog()


        return

    }

    private fun openDialog() {
        val builder = AlertDialog.Builder(this)
        if (currentScore > scoreToBeat)
            builder.setMessage(getString(R.string.alert_highscore_message) + "$currentScore")
        else
            builder.setMessage(getString(R.string.final_score_message) + "$currentScore")
        builder.apply {
            setPositiveButton(
                R.string.alert_ok
            ) { dialog, id ->
                finish()
            }

        }
        builder.setOnDismissListener { finish() }

        val dialog: AlertDialog? = builder.create()
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()


    }


    private fun startGame() {
        counterTextView.visibility = View.GONE
        pointsTextView.visibility = View.VISIBLE
        timerTextView.visibility = View.VISIBLE
        pointsTextView.text = currentScore.toString()
        gameTime = System.currentTimeMillis()
        gameView.setOnClickListener {
            currentScore++
            pointsTextView.text = currentScore.toString()

        }

        val timerGameTime = Timer(timerTextView, GAME_TIME) { finishGame() }
        timerGameTime.start()

        return


    }
}
