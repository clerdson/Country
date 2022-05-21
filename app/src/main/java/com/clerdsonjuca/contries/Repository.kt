package com.clerdsonjuca.contries

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDatasource: RemoteDatasource
    ):BaseApiResponse() {
// suspend fun getContry():Response<List<Country>> {
//        return remoteDatasource.getContry()
// }
    suspend fun getContry():Flow<NetworkResult<List<Country>>>{
        return flow<NetworkResult<List<Country>>>{
            emit(safeApiCall{remoteDatasource.getContry()})
        }.flowOn(Dispatchers.IO)
    }
}