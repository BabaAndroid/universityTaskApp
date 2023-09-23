package com.university.app.server

import com.university.app.data.model.University
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("search?country=United+States")
    suspend fun getUniversityListFromServer(): Response<University>

}
