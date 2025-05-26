package petklinik.backend

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.EnableTransactionManagement

// We don't use @SpringBootApplication since we don't need component scanning
@EnableAutoConfiguration
@SpringBootConfiguration(proxyBeanMethods = false)
@Import(Beans::class)
@EnableCaching
@EnableTransactionManagement
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}