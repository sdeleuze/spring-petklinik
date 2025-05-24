package petklinik.backend.pet

import org.springframework.data.annotation.Id

data class PetImage(
    val image: ByteArray,
    @Id
    val id: Int? = null,
)