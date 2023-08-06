package pe.idat.frontend.api

import pe.idat.frontend.api.models.ChangePasswordRequest
import pe.idat.frontend.api.models.ChangePasswordResponse
import pe.idat.frontend.api.models.ForgotPasswordRequest
import pe.idat.frontend.api.models.ForgotPasswordResponse
import pe.idat.frontend.api.models.Membership
import pe.idat.frontend.api.models.SignInRequest
import pe.idat.frontend.api.models.SignInResponse
import pe.idat.frontend.api.models.SignUpRequest
import pe.idat.frontend.api.models.SignUpResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {

    @POST("api/authentication/sign-in")
    fun signIn(@Body signInRequest: SignInRequest): Call<SignInResponse>

    @POST("api/authentication/sign-up")
    fun signUp(@Body signUpRequest: SignUpRequest): Call<SignUpResponse>

    @GET("authentication/verify/{verificationCode}")
    fun verify(@Path("verificationCode") verificationCode: String): Call<Void>

    @POST("authentication/forgot-password")
    fun forgotPassword(@Body request: ForgotPasswordRequest): Call<ForgotPasswordResponse>

    @POST("authentication/change-password")
    fun changePassword(@Body request: ChangePasswordRequest): Call<ChangePasswordResponse>
}