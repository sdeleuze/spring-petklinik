package petklinik.backend.pet

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.paramOrNull
import org.springframework.web.servlet.function.router
import petklinik.backend.owner.OwnerRepository
import petklinik.backend.owner.toDto
import petklinik.backend.visit.VisitRepository
import petklinik.common.pet.renderPetForm
import java.net.URI
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun petRouter(ownerRepository: OwnerRepository,
              petRepository: PetRepository,
              visitRepository: VisitRepository,
              petManagement: PetManagement) = router {

    GET("/owners/{id}/pets/new") {
        val id = it.pathVariable("id").toInt()
        val owner = ownerRepository.findById(id)
        ok().contentType(MediaType.TEXT_HTML).body(renderPetForm(owner
            .toDto(petRepository, visitRepository), petRepository.findPetTypes().map { it.toDto() }))
    }

    POST("/owners/{id}/pets/new") {
        val id = it.pathVariable("id").toInt()
        val pet = Pet(
            it.paramOrNull("name")!!,
            LocalDate.parse(it.paramOrNull("birthDate")!!, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            it.paramOrNull("typeId")!!.toInt(),
            id
        )
        val imagePrompt = it.paramOrNull("imagePrompt")
        petManagement.create(pet, imagePrompt)
        seeOther(URI("/owners/$id/detail")).build()
    }

    GET("/pets/images/{id}") {
        val id = it.pathVariable("id").toInt()
        ok().contentType(MediaType.IMAGE_PNG).body(petManagement.findImage(id).image)
    }
}