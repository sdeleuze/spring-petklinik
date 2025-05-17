package petklinik.backend.vet

import org.springframework.data.annotation.Id
import petklinik.common.vet.SpecialtyDto

data class Specialty(
    val name: String,
    @Id val id: Int? = null
)

fun Specialty.toDto() = SpecialtyDto(
    this.name,
    this.id
)
