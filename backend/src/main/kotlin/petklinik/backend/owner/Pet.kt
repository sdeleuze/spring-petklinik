package petklinik.backend.owner

import kotlinx.datetime.toKotlinLocalDate
import org.springframework.data.annotation.Id
import org.springframework.format.annotation.DateTimeFormat
import petklinik.backend.visit.VisitRepository
import petklinik.backend.visit.toDto
import petklinik.common.owner.PetDto

data class Pet(
    val name: String,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val birthDate: java.time.LocalDate,
    val typeId: Int,
    val ownerId: Int,
    @Id
    val id: Int?
)

fun Pet.toDto(petRepository: PetRepository, visitRepository: VisitRepository) = PetDto(
    this.name,
    this.birthDate.toKotlinLocalDate(),
    petRepository.findPetType(this.typeId).toDto(),
    if (this.id != null) visitRepository.findByPetId(this.id).map { it.toDto() } else null,
    this.id

)