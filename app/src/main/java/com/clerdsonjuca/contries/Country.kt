package com.clerdsonjuca.contries

import com.google.gson.annotations.SerializedName

data class Country (val name:Name? )
data class Name(
    val common:String?= ""
)