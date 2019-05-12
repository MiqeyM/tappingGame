package com.example.android.tappinggame.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores_table")
class ScoreEntry(@PrimaryKey(autoGenerate = true) val id: Int, val points: Int, val timeStamp: Float) {



}
