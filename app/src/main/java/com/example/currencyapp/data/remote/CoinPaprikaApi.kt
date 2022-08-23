package com.example.currencyapp.data.remote

import com.example.currencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById()
}