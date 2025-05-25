package petklinik.common.fragment

import kotlinx.html.DIV
import kotlinx.html.div
import kotlinx.html.label
import kotlinx.html.option
import kotlinx.html.select

fun DIV.selectField(label: String, name: String, items: List<Pair<Int, String>>) {
    div(classes = "form-group") {
        label(classes = "col-sm-2 control-label") {
            +label
        }
        div(classes = "col-sm-10") {
            select(classes = "form-control") {
                for (item in items) {
                    this.name = name
                    option {
                        value = item.first.toString()
                        this.label = item.second
                    }
                }
            }
        }
    }
}