package com.example.currencyapp.data.repository

import com.example.currencyapp.data.remote.CoinPaprikaApi
import com.example.currencyapp.data.remote.dto.CoinDetailDto
import com.example.currencyapp.data.remote.dto.CoinDto
import com.example.currencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}