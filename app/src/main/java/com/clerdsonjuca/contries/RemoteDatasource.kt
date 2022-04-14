package com.clerdsonjuca.contries

import javax.inject.Inject

class RemoteDatasource @Inject constructor( val api:CountryApi) {

    suspend fun getContry() =
        api.all()
}