package petklinik

import org.springframework.beans.factory.BeanRegistrarDsl
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.client.RestClient
import petklinik.backend.owner.ownerRouter
import petklinik.backend.owner.petRouter
import petklinik.backend.vet.vetRouter

class Beans : BeanRegistrarDsl({
    val imageGeneratorUrl = env.getRequiredProperty("image.generator.url")
    registerBean(::globalRouter)
    registerBean(::petRouter)
    registerBean(::vetRouter)
    registerBean(::ownerRouter)
    registerBean<RestClient> {
        bean<RestClient.Builder>().baseUrl(imageGeneratorUrl).build()
    }
    registerBean {
        HttpMessageConverters(false, listOf(StringHttpMessageConverter(), KotlinSerializationJsonHttpMessageConverter()))
    }
})