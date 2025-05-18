package petklinik.common

import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun renderLayout(activeMenu: Menu, layoutContent: DIV.() -> Unit = {}) = createHTML().html {
    head {
        meta {
            httpEquiv = "Content-Type"
            content = "text/html; charset=UTF-8"
        }
        meta {
            charset = "utf-8"
        }
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1"
        }
        link {
            rel = "stylesheet"
            href = "/css/petclinic.css"
        }
        link {
            rel = "shortcut icon"
            href="/images/favicon.png"
        }
        script {
            type = "text/javascript"
            src = "/frontend.js"
        }
        title("PetClinic :: a Spring Framework demonstration")
    }
    body {
        nav(classes = "navbar navbar-default") {
            div(classes = "container") {
                div(classes = "navbar-header") {
                    a(classes = "navbar-brand", href="/") {
                        span()
                    }
                    button(type = ButtonType.button, classes = "navbar-toggle") {
                        attributes["data-toggle"] = "collapse"
                        attributes["data-target"] = "#main-navbar"
                        span(classes = "sr-only") {
                            +"Toggle navigation"
                        }
                        span(classes = "icon-bar")
                        span(classes = "icon-bar")
                        span(classes = "icon-bar")

                    }
                }
                div(classes = "navbar-collapse collapse") {
                    id = "main-navbar"
                    ul("nav navbar-nav navbar-right") {
                        li {
                            if (activeMenu == Menu.HOME) {
                                classes = setOf("active")
                            }
                            a(href="/") {
                                title = "home page"
                                span(classes ="glyphicon glyphicon-home")
                                span { +" Home" }
                            }
                        }
                        li {
                            if (activeMenu == Menu.OWNERS) {
                                classes = setOf("active")
                            }
                            a(href="/owners/find") {
                                title = "find owners"
                                span(classes ="glyphicon glyphicon-search")
                                span { +" Find owners" }
                            }
                        }
                        li {
                            if (activeMenu == Menu.VETS) {
                                classes = setOf("active")
                            }
                            a(href="/vets.html") {
                                title = "veterinarians"
                                span(classes ="glyphicon glyphicon-th-list")
                                span { +" Veterinarians" }
                            }
                        }
                        li {
                            a(href="/oups") {
                                title = "trigger a RuntimeException to see how it is handled"
                                span(classes ="glyphicon glyphicon-warning-sign")
                                span { +" Error" }
                            }
                        }
                    }
                }
            }
        }
        div(classes = "container-fluid") {
            div(classes = "container xd-container") {
                layoutContent()
            }
            br()
            br()
            div(classes = "container") {
                div(classes = "row") {
                    div(classes = "col-12 text-center") {
                        img(src = "/images/spring-logo.png", alt="Sponsored by VMware Tanzu") {  }
                    }
                }
            }
        }

    }
}
