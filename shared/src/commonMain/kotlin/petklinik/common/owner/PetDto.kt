package petklinik.common.owner

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import petklinik.common.visit.VisitDto

@Serializable
data class PetDto(
    val name: String,
    val birthDate: LocalDate,
    val type: PetTypeDto,
    val visits: List<VisitDto>? = null,
    val id: Int? = null
)