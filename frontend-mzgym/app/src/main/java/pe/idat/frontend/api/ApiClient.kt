package pe.idat.frontend.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://mzgymback.onrender.com"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }

    val membershipService: MembershipService by lazy {
        retrofit.create(MembershipService::class.java)
    }

    val gymService: GymService by lazy {
        retrofit.create(GymService::class.java)
    }

}