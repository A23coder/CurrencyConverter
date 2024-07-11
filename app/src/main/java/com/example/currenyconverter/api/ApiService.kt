package com.example.currenyconverter.api

import com.example.currenyconverter.models.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("latest/{CC}")
    fun getLatestRates(@Path("CC") CC: String): Call<ExchangeRatesResponse>
}