package com.example.moviefun

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Movies::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MovieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Movie_Database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
