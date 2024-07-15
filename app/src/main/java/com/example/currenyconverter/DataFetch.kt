package com.example.currenyconverter

import com.example.currenyconverter.api.RetrofitInstance
import com.example.currenyconverter.models.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    fetchLatestRates()
}

fun fetchLatestRates() {
    val call = RetrofitInstance.api.getLatestRates("AUD")
    val currencyCodeText="INR"

    call.enqueue(object : Callback<ExchangeRatesResponse> {
        override fun onResponse(
            call: Call<ExchangeRatesResponse> ,
            response: Response<ExchangeRatesResponse> ,
        ) {
            val ccList = mutableListOf("")
            if (response.isSuccessful) {
                val countryCodes = response.body()!!.conversion_rates.keys
                ccList.add(countryCodes.toString())
            }
            println(ccList)
            for (i in ccList) {
                println(i)
            }
//            if (response.isSuccessful) {
//                val rates = response.body()
//                if (rates != null) {
//                    for ((currencyCode , rate) in rates.conversion_rates) {
//                        if (currencyCode == currencyCodeText) {
//                            println("Currency code is $currencyCode RATE IS $rate")
//                        }
//                    }
//                } else {
//                    println("Error: Response body is null")
//                }
//            } else {
//                println("Error: ${response.errorBody()?.string()}")
//            }
        }

        override fun onFailure(call: Call<ExchangeRatesResponse> , t: Throwable) {
            println("Failure: ${t.message}")
        }
    })
}
