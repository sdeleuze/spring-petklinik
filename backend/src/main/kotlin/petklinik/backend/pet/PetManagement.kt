package petklinik.backend.pet

import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestClient
import org.springframework.web.client.requiredBody
import org.springframework.web.util.UriUtils
import petklinik.backend.visit.VisitRepository
import petklinik.common.pet.validatePet
import java.net.URI
import java.nio.charset.StandardCharsets

@Transactional
class PetManagement(
    private val petRepository: PetRepository,
    private val petImageRepository: PetImageRepository,
    private val visitRepository: VisitRepository,
    private val restClient: RestClient) {


    fun create(pet: Pet, imagePrompt: String?): Pet {
        val petDto = pet.toDto(petRepository, visitRepository)
        val validation = validatePet(petDto)
        if (!validation.isValid) {
            throw IllegalStateException()
        }
        val createdPet = if (imagePrompt != null && !imagePrompt.isEmpty()) {
            val imageUrl = restClient.get()
                .uri("/${UriUtils.encode(imagePrompt, StandardCharsets.UTF_8)}")
                .retrieve().requiredBody<String>()
            val image = restClient.get().uri(URI(imageUrl)).retrieve().requiredBody<ByteArray>()
            val petImage = PetImage(image)
            val petImageId = petImageRepository.save(petImage).id
            pet.copy(imageId = petImageId)
        }
        else {
            pet
        }
        return petRepository.save(createdPet)
    }

    @Transactional(readOnly = false)
    fun findImage(@Param("petImageId") id: Int) = petImageRepository.findImage(id)
}