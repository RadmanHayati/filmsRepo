package com.fanap.radman.data.remote.response

data class Result(
    val actors: String,
    val age: Int,
    val cardType: String,
    val category: String,
    val company: String,
    val content: String,
    val country: String,
    val coverImage: String,
    val customPostType: String,
    val directors: String,
    val enName: String,
    val genres: List<String>,
    val imdbCode: String,
    val imdbRank: Double,
    val isHot: Boolean,
    val isSearchable: Boolean,
    val mode: String,
    val name: String,
    val nonFree: Boolean,
    val previewImage: String,
    val productProviders: List<ProductProvider>,
    val publishDate: Int,
    val quality: String,
    val trailerPath: String
)