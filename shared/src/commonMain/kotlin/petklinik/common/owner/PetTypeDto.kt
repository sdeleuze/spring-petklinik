package petklinik.common.owner

import kotlinx.serialization.Serializable

@Serializable
data class PetTypeDto(
    val name: String,
    val id: Int? = null
)
