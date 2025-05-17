package petklinik.common.vet

import kotlinx.serialization.Serializable

@Serializable
data class VetDto(
    val firstName: String,
    val lastName: String,
    val specialties: Set<SpecialtyDto>,
    val id: Int? = null
)