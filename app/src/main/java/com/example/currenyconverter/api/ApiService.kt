package com.example.currenyconverter.api

import com.example.currenyconverter.models.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("latest/INR")
    fun getLatestRates(): Call<ExchangeRatesResponse>
}