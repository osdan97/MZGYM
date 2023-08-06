package pe.idat.frontend.api.models

data class SignInResponse(
    val accountUuid: String,
    val email: String,
    val password: String,
    val rol: String,
    val createdDate: String,
    val lastSessionDate: String,
    val active: Boolean,
    val verificationCode: String,
    val tokenPassword: String?,
    val token: String?,
    val number: String,
    val name: String,
    val lastName: String,
    val address: String?,
    val documentType: String?,
    val documentNumber: String?,
    val membershipState: String
)
