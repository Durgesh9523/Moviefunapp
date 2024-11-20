package com.example.moviefun

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovie(movie: Movies)

    @Query("SELECT * FROM fav_movie")
    fun getAllMovie(): LiveData<List<Movies>>
}