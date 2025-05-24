package petklinik.common.pet

import kotlinx.serialization.Serializable

@Serializable
data class PetTypeDto(
    val name: String,
    val id: Int? = null
)
