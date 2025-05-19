package petklinik.common.owner

import io.konform.validation.Validation
import io.konform.validation.constraints.notBlank
import io.konform.validation.constraints.pattern
import kotlinx.serialization.Serializable
import petklinik.common.visit.VisitDto

@Serializable
data class PetDto(
    val name: String,
    val birthDate: String,
    val type: PetTypeDto,
    val visits: List<VisitDto>? = null,
    val id: Int? = null
)

val validatePet = Validation<PetDto> {
    PetDto::name {
        notBlank()
    }
    PetDto::birthDate {
        notBlank()
        pattern("(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))")
    }
}