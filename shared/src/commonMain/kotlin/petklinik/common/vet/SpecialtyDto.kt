package petklinik.common.vet

import kotlinx.serialization.Serializable

@Serializable
data class SpecialtyDto(
    val name: String,
    val id: Int? = null
)
