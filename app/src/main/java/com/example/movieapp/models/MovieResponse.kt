package com.example.movieapp.models

import com.google.gson.annotations.SerializedName

//// Lớp để chứa dữ liệu phản hồi từ API cho danh sách phim
data class MovieResponse(
//    @SerializedName("page")
//    val page: Int,
//    @SerializedName("results")
//    val movies: List<Movie>
//    @SerializedName("total_pages")
//    val totalPages: Int,
//    @SerializedName("total_results")
//    val totalResults: Int
    val page: Int,
    val results: List<Movie>, // Đây là danh sách các phim trả về từ API
    val total_results: Int,
    val total_pages: Int
)
//
//// Lớp để chứa thông tin chi tiết của một bộ phim
//data class Movie(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("overview")
//    val overview: String,
//    @SerializedName("poster_path")
//    val posterPath: String,
//    @SerializedName("backdrop_path")
//    val backdropPath: String,
//    @SerializedName("vote_average")
//    val voteAverage: Double,
//    @SerializedName("release_date")
//    val releaseDate: String
//)
//data class Movie(
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("overview")
//    val overview: String,
//    @SerializedName("poster_path")
//    val posterPath: String
//)
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String
)