package com.sgshreya.retrofit

import api.VirusJSON
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {
    @GET("/summary")
    fun getFacts():Call<VirusJSON>
}