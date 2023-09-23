package com.university.app.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        @Volatile
        private var instance: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            return instance ?: synchronized(this) {
                val retrofit = Retrofit.Builder().baseUrl("http://universities.hipolabs.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit
                retrofit
            }
        }
    }
}
