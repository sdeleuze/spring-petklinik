package petklinik.common

import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.img

fun renderWelcome() = renderLayout(Menu.HOME) {
    h2 {
        +"Welcome"
    }
    div(classes = "row") {
        div(classes = "col-md-12")
        img(classes = "img-responsive", src = "images/pets.png")
    }
}