package petklinik.backend

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableAutoConfiguration
@EnableCaching
@EnableTransactionManagement
@Import(Beans::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}