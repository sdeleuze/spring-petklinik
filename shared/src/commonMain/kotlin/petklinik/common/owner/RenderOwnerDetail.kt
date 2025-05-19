package petklinik.common.owner

import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.html.a
import kotlinx.html.br
import kotlinx.html.dd
import kotlinx.html.dl
import kotlinx.html.dt
import kotlinx.html.h2
import kotlinx.html.img
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import petklinik.common.Menu
import petklinik.common.renderLayout

fun renderOwnerDetail(owner: OwnerDto) = renderLayout(Menu.OWNERS) {
    h2 {
        +"Owner Information"
    }

    table(classes = "table table-striped") {
        tr {
            th {
                +"Name"
            }
            td {
                +"${owner.firstName} ${owner.lastName}"
            }
        }
        tr {
            th {
                +"Address"
            }
            td {
                +owner.address
            }
        }
        tr {
            th {
                +"City"
            }
            td {
                +owner.city
            }
        }
        tr {
            th {
                +"Telephone"
            }
            td {
                if (owner.telephone != null) {
                    +owner.telephone
                }
            }
        }
    }

    a(href = "/owners/${owner.id}/edit", classes = "btn btn-default") {
        +"Edit Owner"
    }
    +" "
    a(href = "/owners/${owner.id}/pets/new", classes = "btn btn-default") {
        +"Add New Pet"
    }

    br { }
    br { }
    br { }

    h2 {
        +"Pets and Visits"
    }

    table(classes = "table table-striped") {
        for(pet in owner.pets) {
            tr {
                td {
                    if (pet.imageUrl != null) {
                        a(href=pet.imageUrl, target = "_blank") {
                            img(src = pet.imageUrl) {
                                width = "128px"
                                height = "128px"
                            }
                        }
                    }
                }
                td {
                    dl(classes = "dl-horizontal") {
                        dt {
                            +"Name"
                        }
                        dd {
                            +pet.name
                        }
                        dt {
                            +"Birth Date"
                        }
                        dd {
                            +pet.birthDate
                        }
                        dt {
                            +"Type"
                        }
                        dd {
                            +pet.type.name
                        }
                    }
                }
                td {
                    table(classes = "table-condensed") {
                        thead {
                            tr {
                                th {
                                    +"Visit Date"
                                }
                                th {
                                    +"Description"
                                }
                            }
                            for (visit in pet.visits!!) {
                                tr {
                                    td {
                                        +visit.visitDate.format(LocalDate.Formats.ISO)
                                    }
                                    td {
                                        +visit.description
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}