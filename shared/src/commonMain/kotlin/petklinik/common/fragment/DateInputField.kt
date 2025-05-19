package petklinik.common.fragment

import kotlinx.html.DIV
import kotlinx.html.div
import kotlinx.html.label
import kotlinx.html.textInput

fun DIV.dateInputField(label: String, name: String, text: String? = null) {
    div(classes = "form-group") {
        label(classes = "col-sm-2 control-label") {
            +label
        }
        div(classes = "col-sm-10") {
            textInput(classes = "form-control", name = name) {
                placeholder = "YYYY-MM-DD"
                pattern = "(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                if (text != null) {
                    value = text
                }
            }
        }
    }
}