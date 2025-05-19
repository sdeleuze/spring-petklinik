package petklinik.common.pet

import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.label
import kotlinx.html.span
import petklinik.common.Menu
import petklinik.common.fragment.dateInputField
import petklinik.common.fragment.selectField
import petklinik.common.fragment.textInputField
import petklinik.common.owner.OwnerDto
import petklinik.common.owner.PetTypeDto
import petklinik.common.renderLayout

fun renderPetForm(owner: OwnerDto, types: List<PetTypeDto>) = renderLayout(Menu.OWNERS) {
    h2 {
        +"New Pet"
    }

    form(classes = "form-horizontal", method = FormMethod.post) {
        id = "pet-form"

        div(classes = "form-group has-feedback") {
            div(classes = "form-group") {
                label(classes = "col-sm-2 control-label") {
                    +"Owner"
                }
                div("col-sm-10") {
                    span {
                        +"${owner.firstName} ${owner.lastName}"
                    }
                }
            }
            textInputField("Name", "name")
            dateInputField("Birth Date", "birthDate")
            selectField("Type", "typeId", types.map { Pair(it.id!!, it.name) })
        }
        div(classes = "form-group") {
            div(classes = "col-sm-offset-2 col-sm-10") {
                button(classes = "btn btn-default", type = ButtonType.submit) {
                    +"Add Pet"
                }
            }
        }
    }
}
