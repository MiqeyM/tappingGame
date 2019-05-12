package com.example.android.tappinggame.game

import android.os.CountDownTimer
import android.text.format.DateUtils.SECOND_IN_MILLIS

import android.view.View
import android.widget.TextView


class Timer(val v: TextView,val countDownTime : Long, private val onFinished: () -> (Unit)) : CountDownTimer(countDownTime, SECOND_IN_MILLIS) {


    override fun onFinish() {
        onFinished()
    }

    override fun onTick(p0: Long) {

        v.text = (p0 / SECOND_IN_MILLIS).toString() + "..."
        //TODO Change string formatting
    }


}

