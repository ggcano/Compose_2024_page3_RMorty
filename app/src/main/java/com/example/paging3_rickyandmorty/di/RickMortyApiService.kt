package com.example.paging3_rickyandmorty.di

import com.example.paging3_rickyandmorty.model.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {
    @GET("/api/character/")
    suspend fun getCharacters(@Query("query") page:Int): ResponseWrapper

}