package com.example.moviefun

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddFavourite : AppCompatActivity() {
    private lateinit var movie_name: EditText
    private lateinit var genreSpinner: Spinner
    private lateinit var submitButton: Button
    private val movieViewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_favourite)
        movie_name=findViewById(R.id.movie_name)
        genreSpinner=findViewById(R.id.genre_spinner)
        submitButton = findViewById(R.id.submit_button)
        val genres = listOf("Action", "Comedy", "Drama", "Horror", "Sci-Fi", "Romance", "Thriller", "Fantasy", "Documentary")
        val genreAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genres)
        genreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genreSpinner.adapter = genreAdapter
        submitButton.setOnClickListener {
            val movieNameText = movie_name.text.toString()
            val selectedGenreType = genreSpinner.selectedItem.toString()

            // Validate inputs
             if (movieNameText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            } else {
                val movie = Movies(
                    MovieName = movieNameText,
                    Genre = selectedGenreType
                )
                // Insert fixture into the database
                movieViewModel.insert(movie)
                Toast.makeText(this, "Movie added in Favourites", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}