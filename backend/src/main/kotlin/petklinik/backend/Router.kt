package petklinik.backend

import org.springframework.http.MediaType
import org.springframework.web.servlet.function.router
import petklinik.common.renderWelcome

fun globalRouter() = router {

    GET("/") {
        ok().contentType(MediaType.TEXT_HTML).body(renderWelcome())
    }

    GET("/oups") {
        throw RuntimeException("Expected: controller used to showcase what happens when an exception is thrown")
    }
}