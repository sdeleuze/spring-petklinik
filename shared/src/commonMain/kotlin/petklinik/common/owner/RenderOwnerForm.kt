package petklinik.common.owner

import kotlinx.html.*
import petklinik.common.Menu
import petklinik.common.fragment.textInputField
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