package pe.idat.frontend.api.models

import com.google.gson.annotations.SerializedName

data class Membership(
    @SerializedName("membershipUuid") val membershipUuid: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Double,
    @SerializedName("membershipState") val membershipState: String,
    @SerializedName("description") val description: String,
    @SerializedName("daysDuration") val daysDuration: Int
)
