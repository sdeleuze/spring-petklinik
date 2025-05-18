package petklinik.common.owner

import kotlinx.html.*
import petklinik.common.Menu
import petklinik.common.renderLayout

fun renderFindOwners() = renderLayout(Menu.OWNERS) {
    h2 { +"Find Owners" }

    form(classes = "form-horizontal") {
        id = "search-owner-form"
        div(classes = "form-group") {
            div(classes = "control-group") {
                id = "lastNameGroup"
                label(classes = "col-sm-2 control-label") {
                    +"Last name "
                }
                div(classes = "col-sm-10") {
                    input(classes = "form-control") {
                        id = "search-owner-input"
                        size = "30"
                        maxLength = "80"
                    }
                }

            }
        }
        div(classes = "form-group") {
            div(classes = "col-sm-offset-2 col-sm-10") {
                button(type = ButtonType.submit, classes = "btn btn-default") {
                    id = "search-owner-button"
                    +"Find Owner"
                }
            }
        }

    }
    div {
        id = ("owner-list")
    }
}