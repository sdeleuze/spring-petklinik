package petklinik.backend.vet

import petklinik.common.vet.SpecialtyDto
import petklinik.common.vet.VetDto

/**
 * Reference between [VetDto] and [SpecialtyDto] required to have many to many relationships in Spring Data JDBC.
 */
data class VetSpecialty(
    val specialty: Int,
    val vet: Int
)