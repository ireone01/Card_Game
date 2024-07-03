package com.example.movieapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.movieapp.network.MovieService
object ApiClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService: MovieService = retrofit.create(MovieService::class.java)
}
