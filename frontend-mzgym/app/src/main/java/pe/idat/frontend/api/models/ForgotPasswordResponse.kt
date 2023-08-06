package pe.idat.frontend.api.models

data class ForgotPasswordResponse(
    val mailFrom: String,
    val mailTo: String,
    val subject: String,
    val fullName: String,
    val token: String
)
