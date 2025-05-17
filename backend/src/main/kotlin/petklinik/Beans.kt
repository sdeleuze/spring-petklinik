package petklinik

import org.springframework.beans.factory.BeanRegistrarDsl
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import petklinik.backend.owner.ownerRouter
import petklinik.backend.vet.vetRouter

class Beans : BeanRegistrarDsl({
    registerBean(::globalRouter)
    registerBean(::vetRouter)
    registerBean(::ownerRouter)
    registerBean {
        HttpMessageConverters(false, listOf(StringHttpMessageConverter(), KotlinSerializationJsonHttpMessageConverter()))
    }
})