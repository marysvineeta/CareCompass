package com.example.carecompass.data.remote

import com.example.carecompass.data.model.Quote
import retrofit2.http.GET

interface QuoteApiService {
    @GET("random")
    suspend fun getRandomQuote(): Quote
}
