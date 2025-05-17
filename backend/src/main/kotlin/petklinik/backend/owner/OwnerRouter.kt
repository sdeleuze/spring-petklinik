package petklinik.backend.owner

import org.springframework.http.MediaType
import org.springframework.web.servlet.function.bodyWithType
import org.springframework.web.servlet.function.router
import petklinik.backend.visit.VisitRepository
import petklinik.common.owner.renderFindOwners
import petklinik.common.owner.renderOwnerDetail

fun ownerRouter(ownerRepository: OwnerRepository, petRepository: PetRepository, visitRepository: VisitRepository) = router {
    GET("/owners/find") {
        ok().contentType(MediaType.TEXT_HTML).body(renderFindOwners())
    }
    GET("/owners") {
        val owners = ownerRepository.findAll()
        ok().contentType(MediaType.APPLICATION_JSON).bodyWithType(owners.map { it.toDto(petRepository, visitRepository) })
    }
    GET("/owners/{lastName}") {
        val lastname = it.pathVariable("lastName")
        val owners = ownerRepository.findByLastName(lastname)
        ok().contentType(MediaType.APPLICATION_JSON).bodyWithType(owners.map { it.toDto(petRepository, visitRepository) })
    }
    GET("/owners/{id}/detail") {
        val id = it.pathVariable("id").toInt()
        val owner = ownerRepository.findById(id)
        ok().contentType(MediaType.TEXT_HTML).body(renderOwnerDetail(owner.toDto(petRepository, visitRepository)))
    }
}