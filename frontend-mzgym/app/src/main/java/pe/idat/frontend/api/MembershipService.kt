package pe.idat.frontend.api

import pe.idat.frontend.api.models.Membership
import retrofit2.Call
import retrofit2.http.GET

interface MembershipService {
    @GET("api/membership/list")
    fun getMemberships(): Call<List<Membership>>
}