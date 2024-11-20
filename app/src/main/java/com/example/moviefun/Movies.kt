package com.example.moviefun

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="fav_movie")
data class Movies (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val MovieName: String,
    val Genre: String
)