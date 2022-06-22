package com.fanap.radman.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.fanap.radman.data.remote.MoviesApi
import com.fanap.radman.data.remote.response.Movies
import com.fanap.radman.repository.MoviesRepository
import com.fanap.radman.ui.MoviesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(
        api: MoviesApi
    ) = MoviesRepository(api = api)

    @Provides
    @Singleton
    fun provideMoviesApi(): MoviesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pbox.fanapsoft.ir/v2/")
            .build()
            .create(MoviesApi::class.java)
    }

}