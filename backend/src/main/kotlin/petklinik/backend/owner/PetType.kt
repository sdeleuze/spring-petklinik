package petklinik.backend.owner

import org.springframework.data.annotation.Id
import petklinik.common.owner.PetTypeDto

data class PetType(
    val name: String,
    @Id
    val id: Int?,
)

fun PetType.toDto() = PetTypeDto(
    this.name,
    this.id
)
