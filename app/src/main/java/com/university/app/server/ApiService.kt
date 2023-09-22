package com.university.app.server

import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("search?country=United+States")
    suspend fun getUniversityListFromServer()

    @POST()
    suspend fun getUserDetails()

}
