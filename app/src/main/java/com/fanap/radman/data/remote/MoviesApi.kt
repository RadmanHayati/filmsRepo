package com.fanap.radman.data.remote

import com.fanap.radman.data.remote.response.Movies
import retrofit2.http.GET
import retrofit2.http.Url

interface MoviesApi {

    @GET
    suspend fun getMoviesList(@Url url: String = "https://pbox.fanapsoft.ir/v2/content/data?category=movie&offset=0&size=50"): Movies

}
