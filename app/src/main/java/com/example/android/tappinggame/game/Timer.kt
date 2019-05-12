package com.example.android.tappinggame.game

import android.os.CountDownTimer
import android.text.format.DateUtils.SECOND_IN_MILLIS

import android.widget.TextView


class Timer(private val v: TextView, countDownTime: Long, private val onFinished: () -> (Unit)) :
    CountDownTimer(countDownTime, SECOND_IN_MILLIS) {


    override fun onFinish() {
        onFinished()
    }

    override fun onTick(p0: Long) {

        v.text = String.format("%01d" + "...", (p0 / SECOND_IN_MILLIS))



    }


}

