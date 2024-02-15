package com.searchaddressapp.data.repository

import com.searchaddressapp.data.remote.AddressApi
import com.searchaddressapp.data.remote.mapper.toAddressInfo
import com.searchaddressapp.domain.model.AddressInfo
import com.searchaddressapp.domain.repository.SearchRepository
import com.searchaddressapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val addressApi: AddressApi
): SearchRepository {

    override suspend fun findAddresses(query: String): Resource<List<AddressInfo>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = addressApi.searchAddress(query)
                val addressResult = response.data?.features?.map { it.toAddressInfo() }
                Resource.Success(addressResult)
            } catch (e: IOException) {
                e.printStackTrace()
                Resource.Error("Couldn't load data")
            } catch (e: HttpException) {
                e.printStackTrace()
                Resource.Error("Couldn't load data")
            }
        }
    }
}