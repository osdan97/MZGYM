package pe.idat.frontend.api.models

data class ChangePasswordRequest(
    val password: String,
    val confirmPassword: String,
    val tokenPassword: String
)
