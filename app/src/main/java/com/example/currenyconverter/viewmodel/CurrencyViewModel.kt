package com.example.currenyconverter.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currenyconverter.api.RetrofitInstance
import com.example.currenyconverter.models.ExchangeRatesResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyViewModel(
    from: String? = null ,
    val to: String? = null ,
) : ViewModel() {
    private val total = 0.0
    private val _conversionResult = mutableStateOf(0.0)
    val conversionResult = _conversionResult

    fun currencyConverter(amount: Double , from: String , to: String) {
        viewModelScope.launch {
            val call = RetrofitInstance.api.getLatestRates(from)
            val toConvertedCurrency = to
            call.enqueue(object : Callback<ExchangeRatesResponse?> {
                override fun onResponse(
                    call: Call<ExchangeRatesResponse?> ,
                    response: Response<ExchangeRatesResponse?> ,
                ) {
                    if (response.isSuccessful) {
                        val rates = response.body()
                        if (rates != null) {
                            for ((currencyCode , rate) in rates.conversion_rates) {
                                if (currencyCode == toConvertedCurrency.trim()) {
                                    _conversionResult.value = rate * amount
                                    println("Currency code is $currencyCode RATE IS $rate")
                                }
                            }
                        } else {
                            _conversionResult.value = 0.0
                        }
                    } else {
                        println("Error: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<ExchangeRatesResponse?> , t: Throwable) {
                    _conversionResult.value = 0.0
                }
            })
        }
    }
}
