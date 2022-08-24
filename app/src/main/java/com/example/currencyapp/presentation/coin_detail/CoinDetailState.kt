package com.example.currencyapp.presentation.coin_detail

import com.example.currencyapp.domain.model.Coin
import com.example.currencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error: String = ""
)
