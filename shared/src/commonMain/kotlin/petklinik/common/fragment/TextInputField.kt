package petklinik.common.fragment

import kotlinx.html.DIV
import kotlinx.html.div
import kotlinx.html.label
import kotlinx.html.textInput

fun DIV.textInputField(label: String, name: String, text: String? = null) {
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