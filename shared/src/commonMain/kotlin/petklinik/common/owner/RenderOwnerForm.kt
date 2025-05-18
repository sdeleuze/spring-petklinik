package petklinik.common.owner

import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FormMethod
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.hiddenInput
import kotlinx.html.id
import kotlinx.html.label
import kotlinx.html.textInput
import petklinik.common.Menu
import petklinik.common.renderLayout

fun renderOwnerForm(owner: OwnerDto ?) = renderLayout(Menu.OWNERS) {
    h2 {
        +"Owner"
    }

    form(classes = "form-horizontal", method = FormMethod.post) {
        id = "owner-form"

        div(classes = "form-group has-feedback") {
            hiddenInput(name = "id") {
                if (owner?.id != null) {
                    value = owner.id.toString()
                }
            }
            textInputField("First Name", "firstName", owner?.firstName)
            textInputField("Last Name", "lastName", owner?.lastName)
            textInputField("Address", "address", owner?.address)
            textInputField("City", "city", owner?.city)
            textInputField("Telephone", "telephone", owner?.telephone)
        }

        div(classes = "form-group") {
            div(classes = "col-sm-offset-2 col-sm-10") {
                button(classes = "btn btn-default", type = ButtonType.submit) {
                    +"Update Owner"
                }
            }
        }
    }
}

fun DIV.textInputField(label: String, name: String, text: String?) {
    div(classes = "form-group") {
        label(classes = "col-sm-2 control-label") {
            +label
        }
        div(classes = "col-sm-10") {
            textInput(classes = "form-control", name = name) {
                if (text != null) {
                    value = text
                }
            }
        }
    }
}