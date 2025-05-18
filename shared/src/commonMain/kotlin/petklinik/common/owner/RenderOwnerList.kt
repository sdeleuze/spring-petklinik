package petklinik.common.owner

import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.span
import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr

fun renderOwnerList(owners: List<OwnerDto>) = createHTML().div {
    h2 {
        +"Owners"

        table(classes = "table table-striped") {
            id = "vets"
            thead {
                tr {
                    th(classes = "width-150") {
                        +"Name"
                    }
                    th(classes = "width-200") {
                        +"Address"
                    }
                    th {
                        +"City"
                    }
                    th(classes = "width-100") {
                        +"Telephone"
                    }
                    th {
                        +"Pets"
                    }
                }
            }
            tbody {
                for (owner in owners) {
                    tr {
                        td {
                            a(href = "/owners/${owner.id}/detail") {
                                +"${owner.firstName} ${owner.lastName}"
                            }
                        }
                        td {
                            +owner.address
                        }
                        td {
                            +owner.city
                        }
                        td {
                            if (owner.telephone != null) +owner.telephone
                        }
                        td {
                            for (pet in owner.pets) {
                                span {
                                    +"${pet.name} "
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}