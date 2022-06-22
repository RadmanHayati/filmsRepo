package com.fanap.radman.repository

import android.util.Log
import com.fanap.radman.data.remote.MoviesApi
import com.fanap.radman.data.remote.response.Movies
import com.fanap.radman.util.Resource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MoviesRepository @Inject constructor(
    private val api: MoviesApi
) {
    suspend fun getMoviesList(): Resource<Movies> {
        val response = try {
            api.getMoviesList()
        } catch (e: Exception) {
            Log.i("checkkk", "getMoviesList: $e")
            return Resource.Error("Sth went wrong!")
        }
        Log.i("checkkk", "getMoviesList: $response")
        return Resource.Success(response)
    }


}