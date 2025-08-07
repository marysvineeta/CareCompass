package com.example.carecompass.data.repository

import com.example.carecompass.data.model.Quote
import com.example.carecompass.data.remote.QuoteApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteRepository {

    private val api: QuoteApiService = Retrofit.Builder()
        .baseUrl("https://zenquotes.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuoteApiService::class.java)

    suspend fun getQuote(): Quote {
        return api.getRandomQuote()
    }
}
