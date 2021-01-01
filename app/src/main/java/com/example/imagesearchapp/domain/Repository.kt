package com.example.imagesearchapp.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.imagesearchapp.data.model.UnsplashPagingSource
import retrofit2.http.Query
import javax.inject.Inject

class Repository @Inject constructor(private val unsplashService: UnsplashService){
    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashService, query)}
        ).liveData

}