package com.example.databarang3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class koneksi {
    var baseUrl="https://jsonplaceholder.typicode.com/"
    var retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: GitHubService = retrofit.create(GitHubService::class.java)
}