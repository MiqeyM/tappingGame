package com.example.android.tappinggame.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.tappinggame.entity.ScoreEntry

@Dao
interface ScoreDao {

    @Insert
    suspend fun insert(scoreEntry: ScoreEntry)

    @Query("SELECT * from scores_table ORDER BY points ASC")
    fun getScores(): LiveData<List<ScoreEntry>>


}