package pe.idat.frontend.api.models

import retrofit2.Call
import retrofit2.http.GET

interface MembershipService {
    @GET("api/membership/list")
    fun getMemberships(): Call<List<Membership>>
}