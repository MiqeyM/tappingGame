package com.example.android.tappinggame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.tappinggame.database.ScoreDao
import com.example.android.tappinggame.database.ScoresRepository
import com.example.android.tappinggame.database.ScoresRoomDatabase
import com.example.android.tappinggame.entity.ScoreEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//class ScoreViewModel(application: Application) : ViewModel() {
//
//    private val repository : ScoresRepository
//    val allScores: LiveData<List<ScoreEntry>>
//
//    init{
//        val scoreDao = ScoresRoomDatabase.getDatabase(application).scoreDao()
//        repository = ScoresRepository(scoreDao)
//        allScores = repository.allScores
//    }
//
//    fun insert(score: ScoreEntry) =  viewModelScope.launch(Dispatchers.IO){
//        repository.insert(score)
//    }
//}

class MoviesViewModel(application: Application): AndroidViewModel(application) {
    private val scoreDao: ScoreDao = ScoresRoomDatabase.getDatabase(application).scoreDao()

    fun getScores() = scoreDao.getScores()

}