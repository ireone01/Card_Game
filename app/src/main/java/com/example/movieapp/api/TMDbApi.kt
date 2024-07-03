//package com.example.movieapp.api
//
//import com.example.movieapp.models.MovieResponse
//import com.example.movieapp.models.GenreResponse
//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface TMDbApi {
//    @GET("movie/popular")
//    fun getPopularMovies(@Query("733beed5151d34e00b723016d496da87") apiKey: String, @Query("page") page: Int): Call<MovieResponse>
//
//    @GET("movie/now_playing")
//    fun getNowPlayingMovies(@Query("733beed5151d34e00b723016d496da87") apiKey: String, @Query("page") page: Int): Call<MovieResponse>
//
//    @GET("movie/upcoming")
//    fun getUpcomingMovies(@Query("733beed5151d34e00b723016d496da87") apiKey: String, @Query("page") page: Int): Call<MovieResponse>
//
//    @GET("movie/top_rated")
//    fun getTopRatedMovies(@Query("733beed5151d34e00b723016d496da87") apiKey: String, @Query("page") page: Int): Call<MovieResponse>
//
//    @GET("genre/movie/list")
//    fun getMovieGenres(@Query("733beed5151d34e00b723016d496da87") apiKey: String): Call<GenreResponse>
//}
