package pe.idat.frontend.api.models

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val lastName: String
)
