package petklinik.backend

import org.springframework.beans.factory.BeanRegistrarDsl
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.http.converter.ByteArrayHttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.client.RestClient
import petklinik.backend.owner.ownerRouter
import petklinik.backend.pet.PetManagement
import petklinik.backend.pet.petRouter
import petklinik.backend.vet.vetRouter

class Beans : BeanRegistrarDsl({
    registerBean {
        val builder = bean<RestClient.Builder>()
            .baseUrl(env.getRequiredProperty("image.generator.url"))
            .build()
        PetManagement(bean(), bean(), bean(), builder)
    }

    // Router
    registerBean(::globalRouter)
    registerBean(::petRouter)
    registerBean(::vetRouter)
    registerBean(::ownerRouter)

    // Spring Boot configuration
    registerBean {
        HttpMessageConverters(false, listOf(
            ByteArrayHttpMessageConverter(),
            StringHttpMessageConverter(),
            KotlinSerializationJsonHttpMessageConverter()))
    }
})