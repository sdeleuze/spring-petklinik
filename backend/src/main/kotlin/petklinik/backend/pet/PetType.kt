package petklinik.backend.pet

import org.springframework.data.annotation.Id
import petklinik.common.pet.PetTypeDto

data class PetType(
    val name: String,
    @Id
    val id: Int?,
)

fun PetType.toDto() = PetTypeDto(
    this.name,
    this.id
)
