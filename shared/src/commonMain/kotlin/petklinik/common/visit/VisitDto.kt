package petklinik.common.visit

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class VisitDto(
    val visitDate: LocalDate,
    val description: String,
    val id: Int?
)
