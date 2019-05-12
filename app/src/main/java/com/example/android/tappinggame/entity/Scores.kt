package com.example.android.tappinggame.entity

import com.example.android.tappinggame.database.ScoreEntry

interface Scores {

    fun add(score: Collection<ScoreEntry>)

    fun get(): List<ScoreEntry>
}