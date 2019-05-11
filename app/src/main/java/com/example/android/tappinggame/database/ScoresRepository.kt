package com.example.android.tappinggame.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.tappinggame.entity.ScoreEntry

class ScoresRepository(private val scoreDao: ScoreDao) {

    val allScores: LiveData<List<ScoreEntry>> = scoreDao.getScores()

    @WorkerThread
    suspend fun insert(score: ScoreEntry) {
        scoreDao.insert(score)
    }
}