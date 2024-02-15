package com.searchaddressapp.domain.repository

import com.searchaddressapp.domain.model.AddressInfo
import com.searchaddressapp.util.Resource

interface SearchRepository {
    suspend fun findAddresses(query: String): Resource<List<AddressInfo>>
}