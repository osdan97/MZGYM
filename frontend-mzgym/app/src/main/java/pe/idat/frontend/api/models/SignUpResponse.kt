package pe.idat.frontend.api.models

data class SignUpResponse(
    val email: String,
    val password: String,
    val verificationCode: String,
    val fullName: String,
    val token: String
)
