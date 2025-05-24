package petklinik.backend.owner

import org.springframework.data.annotation.Id
import petklinik.backend.pet.PetRepository
import petklinik.backend.pet.toDto
import petklinik.backend.visit.VisitRepository
import petklinik.common.owner.OwnerDto

data class Owner(val firstName: String,
                 val lastName: String,
                 val address: String,
                 val city: String,
                 val telephone: String,
                 @Id val id: Int?
)

fun Owner.toDto(petRepository: PetRepository, visitRepository: VisitRepository) = OwnerDto(
    this.firstName,
    this.lastName,
    this.address,
    this.city,
    this.telephone,
    if (this.id != null) petRepository.findByOwnerId(this.id)
        .map { it.toDto(petRepository, visitRepository) } else emptyList(),
    this.id
)
