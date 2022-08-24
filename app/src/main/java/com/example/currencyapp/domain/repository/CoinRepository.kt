package com.example.currencyapp.domain.repository

import com.example.currencyapp.data.remote.dto.CoinDetailDto
import com.example.currencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}