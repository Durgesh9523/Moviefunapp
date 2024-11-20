package com.example.moviefun
import androidx.lifecycle.LiveData
class MovieRepository (private val movieDao: MovieDao){
    val allMovies: LiveData<List<Movies>> = movieDao.getAllMovie()

    suspend fun insert(movies: Movies) {
        movieDao.insertMovie(movies)
    }
}