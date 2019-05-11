package com.example.android.tappinggame.entity

interface Scores {

    fun add(score: Collection<ScoreEntry>)

    fun get(): List<ScoreEntry>
}