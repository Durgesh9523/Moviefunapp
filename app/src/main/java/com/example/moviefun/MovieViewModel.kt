package com.example.moviefun

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application)  {
    private val repository: MovieRepository
    val allMovies: LiveData<List<Movies>>

    init {
        val moviesDao = AppDatabase.getDatabase(application).MovieDao()
        repository = MovieRepository(moviesDao)
        allMovies = repository.allMovies
    }

    fun insert(movie:Movies) = viewModelScope.launch {
        repository.insert(movie)
    }
}