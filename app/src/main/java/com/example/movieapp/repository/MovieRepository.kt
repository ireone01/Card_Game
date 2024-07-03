package com.example.movieapp.repository

import com.example.movieapp.models.Movie
import com.example.movieapp.network.MovieService

class MovieRepository {
    private val movieService = MovieService.create()

    suspend fun getMovies(apiKey: String): List<Movie> {
        val response = movieService.getPopularMovies(apiKey)
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }
}
