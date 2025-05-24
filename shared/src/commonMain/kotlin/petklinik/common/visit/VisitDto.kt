package petklinik.common.visit

import kotlinx.serialization.Serializable

@Serializable
data class VisitDto(
    val visitDate: String,
    val description: String,
    val id: Int?
)
