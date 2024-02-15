package com.searchaddressapp.data.remote

import com.searchaddressapp.data.remote.model.SearchResponse
import com.searchaddressapp.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface AddressApi {

    @GET("search/")
    suspend fun searchAddress(
        @Query("q") query: String,
        @Query("type") type: String = "housenum"
    ): Resource<SearchResponse>

    companion object {
        const val BASE_URL = "https://api-adresse.data.gouv.fr/"
    }
}