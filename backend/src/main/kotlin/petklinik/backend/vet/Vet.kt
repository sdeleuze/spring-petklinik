package petklinik.backend.vet

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import petklinik.backend.visit.VisitRepository
import petklinik.common.vet.VetDto

data class Vet(
    val firstName: String,
    val lastName: String,
    @MappedCollection
    val specialties: Set<VetSpecialty>,
    @Id
    val id: Int? = null
)

fun Vet.toDto(specialtyRepository: SpecialtyRepository) = VetDto(
        this.firstName,
        this.lastName,
        this.specialties.map { specialtyRepository.findById(it.specialty).toDto() }.toSet(),
        this.id
)
