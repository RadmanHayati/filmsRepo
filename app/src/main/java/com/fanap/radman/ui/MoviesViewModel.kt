package com.fanap.radman.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fanap.radman.data.remote.response.Movies
import com.fanap.radman.repository.MoviesRepository
import com.fanap.radman.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {
    val movies = MutableLiveData<Resource<Movies>>()
    val isLoading = MutableLiveData(false)
    val loadError = MutableLiveData<String>()
    fun loadMoviesList() {
        isLoading.value = true
        viewModelScope.launch {
            val result = repository.getMoviesList()
            when (result) {
                is Resource.Success -> {
                    loadError.value = ""
                    isLoading.value = false
                    movies.postValue(result)
                }
                else -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
            }

        }
    }
}