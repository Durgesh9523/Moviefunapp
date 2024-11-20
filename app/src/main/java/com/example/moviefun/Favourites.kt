package com.example.moviefun

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Favourites : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_favourites, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        // Set up FloatingActionButton to navigate to MatchDetails
        val btn: FloatingActionButton = view.findViewById(R.id.MovieAdd)
        btn.setOnClickListener {
            val intent = Intent(requireContext(), AddFavourite::class.java)
            startActivity(intent)
        }
        movieViewModel.allMovies.observe(viewLifecycleOwner, Observer { Movies ->
            Movies?.let {
                recyclerView.adapter = FavouriteAdapter(it)
            }
        })
        return view
    }
}