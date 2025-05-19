package petklinik.backend.owner

import org.springframework.data.annotation.Id
import petklinik.backend.visit.VisitRepository
import petklinik.backend.visit.toDto
import petklinik.common.owner.PetDto
import java.time.format.DateTimeFormatter

data class Pet(
    val name: String,
    val birthDate: java.time.LocalDate,
    val typeId: Int,
    val ownerId: Int,
    @Id
    val id: Int? = null
)

fun Pet.toDto(petRepository: PetRepository, visitRepository: VisitRepository) = PetDto(
    this.name,
    this.birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    petRepository.findPetType(this.typeId).toDto(),
    if (this.id != null) visitRepository.findByPetId(this.id).map { it.toDto() } else null,
    this.id

)