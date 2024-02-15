package com.searchaddressapp.di

import com.searchaddressapp.data.repository.SearchRepositoryImpl
import com.searchaddressapp.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository
}
