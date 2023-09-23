package com.university.app.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {

        @Volatile
        private var instance: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return instance ?: synchronized(this) {
                val retrofit = Retrofit.Builder().baseUrl("http://universities.hipolabs.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit
                retrofit
            }
        }
    }
}
