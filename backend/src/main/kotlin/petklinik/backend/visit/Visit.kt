package petklinik.backend.visit

import kotlinx.datetime.toKotlinLocalDate
import org.springframework.data.annotation.Id
import petklinik.common.visit.VisitDto
import java.time.LocalDate

data class Visit(
    val visitDate: LocalDate,
    val description: String,
    val petId: Int,
    @Id
    val id: Int?
)

fun Visit.toDto() = VisitDto(
    this.visitDate.toKotlinLocalDate(),
    this.description,
    this.id
)
