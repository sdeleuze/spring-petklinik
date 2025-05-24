package petklinik.backend.visit

import org.springframework.data.annotation.Id
import petklinik.common.visit.VisitDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Visit(
    val visitDate: LocalDate,
    val description: String,
    val petId: Int,
    @Id
    val id: Int?
)

fun Visit.toDto() = VisitDto(
    this.visitDate.format(DateTimeFormatter.ISO_DATE),
    this.description,
    this.id
)
