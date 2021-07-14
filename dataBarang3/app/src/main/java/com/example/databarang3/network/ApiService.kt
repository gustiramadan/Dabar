package com.example.databarang3.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(value = "Users")
    fun getUser(): Call<List<ResponseUsersItem>>



}