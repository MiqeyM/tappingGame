package com.example.android.tappinggame.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ScoreEntry::class], version = 1, exportSchema = false)
abstract class ScoresRoomDatabase : RoomDatabase() {
    abstract fun scoreDao() : ScoreDao

    companion object{
        @Volatile
        private var INSTANCE: ScoresRoomDatabase? = null

        fun getDatabase(context: Context): ScoresRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScoresRoomDatabase::class.java,
                    "scores_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}