package com.example.currencyapp.domain.use_case.get_single_coin

import com.example.currencyapp.common.Resource
import com.example.currencyapp.data.remote.dto.toCoin
import com.example.currencyapp.data.remote.dto.toCoinDetail
import com.example.currencyapp.domain.model.Coin
import com.example.currencyapp.domain.model.CoinDetail
import com.example.currencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }
        catch (e : HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An error occured"))
        }
        catch (e : IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}