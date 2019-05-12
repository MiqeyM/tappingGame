package com.example.android.tappinggame.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {

    @Insert
    suspend fun insert(scoreEntry: ScoreEntry)

    @Query("SELECT * from scores_table ORDER BY points DESC")
    fun getScores(): LiveData<List<ScoreEntry>>


}