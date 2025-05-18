package petklinik.common.vet

import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import petklinik.common.Menu
import petklinik.common.renderLayout

fun renderVets(vets : List<VetDto>) = renderLayout(Menu.VETS) {
    h2 { +"Veterinarians aaaa" }

    table(classes = "table table-striped") {
        id = "vets"
        thead {
            tr {
                th {
                    +"Name"
                }
                th {
                    +"Specialties"
                }
            }
        }
        tbody {
            for(vet in vets) {
                tr {
                    td {
                        +"${vet.firstName} ${vet.lastName}"
                    }
                    td {
                        if (vet.specialties.isEmpty()) {
                            +"none"
                        }
                        else {
                            for (specialty in vet.specialties) {
                                +"specialty: ${specialty.name} "
                            }
                        }
                    }
                }
            }
        }
    }
}