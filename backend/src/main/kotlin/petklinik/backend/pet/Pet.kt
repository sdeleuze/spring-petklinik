package petklinik.backend.pet

import org.springframework.data.annotation.Id
import petklinik.backend.visit.VisitRepository
import petklinik.backend.visit.toDto
import petklinik.common.pet.PetDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class  Pet(
    val name: String,
    val birthDate: LocalDate,
    val typeId: Int,
    val ownerId: Int,
    val imageId: Int? = null,
    @Id
    val id: Int? = null
)

fun Pet.toDto(petRepository: PetRepository, visitRepository: VisitRepository) = PetDto(
    this.name,
    this.birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    petRepository.findPetType(this.typeId).toDto(),
    if (this.id != null) visitRepository.findByPetId(this.id).map { it.toDto() } else null,
    this.imageId,
    this.id
)
