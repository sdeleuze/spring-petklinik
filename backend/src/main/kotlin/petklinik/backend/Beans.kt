package petklinik.backend

import org.springframework.beans.factory.BeanRegistrarDsl
import org.springframework.boot.http.converter.autoconfigure.HttpMessageConverters
import org.springframework.http.converter.ByteArrayHttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.client.RestClient
import petklinik.backend.owner.ownerRouter
import petklinik.backend.pet.PetManagement
import petklinik.backend.pet.petRouter
import petklinik.backend.vet.vetRouter

class Beans : BeanRegistrarDsl({
    // PetManagement bean with a custom RestClient
    registerBean {
        val builder = bean<RestClient.Builder>()
            .baseUrl(env.getRequiredProperty("image.generator.url"))
            .build()
        PetManagement(bean(), bean(), bean(), builder)
    }

    // Router with automatic wiring by type of the function parameters
    registerBean(::globalRouter)
    registerBean(::petRouter)
    registerBean(::vetRouter)
    registerBean(::ownerRouter)

    // Customization of Spring Boot configuration to use only specific HTTP converters
    registerBean {
        HttpMessageConverters(
            false, listOf(
                ByteArrayHttpMessageConverter(),
                StringHttpMessageConverter(),
                KotlinSerializationJsonHttpMessageConverter()
            )
        )
    }

    // Spring Data repositories are scanned automatically so no need to declare them
})