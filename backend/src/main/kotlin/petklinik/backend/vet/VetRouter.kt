package petklinik.backend.vet

import org.springframework.http.MediaType
import org.springframework.web.servlet.function.bodyWithType
import org.springframework.web.servlet.function.router
import petklinik.common.vet.renderVets

fun vetRouter(vetRepository: VetRepository, specialtyRepository: SpecialtyRepository) = router {
    GET("/vets.html") {
        ok().contentType(MediaType.TEXT_HTML)
            .body(renderVets(vetRepository.findAll().map { it.toDto(specialtyRepository) }))
    }
    GET("/vets") {
        ok().contentType(MediaType.APPLICATION_JSON).bodyWithType(vetRepository.findAll().map { it.toDto(specialtyRepository) })
    }
}