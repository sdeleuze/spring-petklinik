package petklinik.backend.owner

import org.springframework.http.MediaType
import org.springframework.web.servlet.function.paramOrNull
import org.springframework.web.servlet.function.router
import petklinik.backend.visit.VisitRepository
import petklinik.common.owner.renderOwnerDetail
import petklinik.common.owner.validatePet
import petklinik.common.pet.renderPetForm
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun petRouter(ownerRepository: OwnerRepository, petRepository: PetRepository, visitRepository: VisitRepository) = router {
    GET("/owners/{id}/pets/new") {
        val id = it.pathVariable("id").toInt()
        val owner = ownerRepository.findById(id)
        ok().contentType(MediaType.TEXT_HTML).body(renderPetForm(owner.toDto(petRepository, visitRepository), petRepository.findPetTypes().map { it.toDto() }))
    }
    POST("/owners/{id}/pets/new") {
        val id = it.pathVariable("id").toInt()
        val pet = Pet(
            it.paramOrNull("name")!!,
            LocalDate.parse(it.paramOrNull("birthDate")!!, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            it.paramOrNull("typeId")!!.toInt(),
            id
        )
        val petDto = pet.toDto(petRepository, visitRepository)
        val validation = validatePet(petDto)
        if (!validation.isValid) {
            throw IllegalStateException()
        }
        petRepository.save(pet)
        val owner = ownerRepository.findById(id)
        ok().contentType(MediaType.TEXT_HTML).body(renderOwnerDetail(owner.toDto(petRepository, visitRepository)))
    }
}