package com.clerdsonjuca.contries

import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject
@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDatasource: RemoteDatasource) {
 suspend fun getContry():Response<List<Country>> {
        return remoteDatasource.getContry()
 }
}