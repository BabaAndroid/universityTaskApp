package com.university.app.server

import retrofit2.http.GET

interface ApiService {

    @GET("search?country=United+States")
    suspend fun getUniversityListFromServer()

}
