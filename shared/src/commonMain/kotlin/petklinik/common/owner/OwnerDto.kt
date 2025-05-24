package petklinik.common.owner

import io.konform.validation.Validation
import io.konform.validation.constraints.maxLength
import io.konform.validation.constraints.minLength
import io.konform.validation.constraints.notBlank
import kotlinx.serialization.Serializable
import petklinik.common.pet.PetDto

@Serializable
data class OwnerDto(val firstName: String,
                    val lastName: String,
                    val address: String,
                    val city: String,
                    val telephone: String?,
                    val pets: List<PetDto>,
                    val id: Int? = null
)

val validateOwner = Validation<OwnerDto> {
    OwnerDto::firstName {
        notBlank()
    }
    OwnerDto::lastName {
        notBlank()
    }
    OwnerDto::address {
        notBlank()
    }
    OwnerDto::city {
        notBlank()
    }
    OwnerDto::telephone ifPresent {
        minLength(10)
        maxLength(10)
    }
}
