package com.example.pleasework

import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("gifs/trending?api_key=GKKSdcAtrgVwo79F6a7fV5eUtJpEM34Y")
    fun getGifs(): Call<DataResult>
}
