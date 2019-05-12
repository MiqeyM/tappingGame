package com.example.android.tappinggame.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {

    @Insert
    suspend fun insert(scoreEntry: ScoreEntry)


    //TODO: Put sorting into different place with validation
    @Query("SELECT * from scores_table ORDER BY points DESC")
    fun getScores(): LiveData<List<ScoreEntry>>


}