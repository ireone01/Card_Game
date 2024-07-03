package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.Movie
import com.example.movieapp.network.MovieService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun getMovies(apiKey: String) {
        viewModelScope.launch {
            val movieService = MovieService.create()
            val response = movieService.getPopularMovies(apiKey)
            if (response.isSuccessful) {
                _movies.postValue(response.body()?.results ?: emptyList())
            } else {
                _movies.postValue(emptyList())
            }
        }
    }
}
