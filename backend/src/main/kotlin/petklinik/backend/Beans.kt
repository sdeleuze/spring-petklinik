package petklinik.backend

import org.springframework.beans.factory.BeanRegistrarDsl
import org.springframework.web.client.RestClient
import petklinik.backend.owner.OwnerRepository
import petklinik.backend.owner.ownerRouter
import petklinik.backend.pet.PetImageRepository
import petklinik.backend.pet.PetManagement
import petklinik.backend.pet.PetRepository
import petklinik.backend.pet.petRouter
import petklinik.backend.vet.SpecialtyRepository
import petklinik.backend.vet.VetRepository
import petklinik.backend.vet.vetRouter
import petklinik.backend.visit.VisitRepository

class Beans : BeanRegistrarDsl({
    // PetManagement bean with a custom RestClient
    registerBean {
        val builder = bean<RestClient.Builder>()
            .baseUrl(env.getRequiredProperty("image.generator.url"))
            .build()
        PetManagement(bean<PetRepository>(), bean<PetImageRepository>(), bean<VisitRepository>(), builder)
    }

    // Router with automatic wiring by type of the function parameters
    registerBean { globalRouter() }
    registerBean { petRouter(bean<OwnerRepository>(), bean<PetRepository>(), bean<VisitRepository>(), bean<PetManagement>()) }
    registerBean { vetRouter(bean<VetRepository>(), bean<SpecialtyRepository>()) }
    registerBean { ownerRouter(bean<OwnerRepository>(), bean<PetRepository>(), bean<VisitRepository>()) }

    // Spring Data repositories are scanned automatically so no need to declare them
})