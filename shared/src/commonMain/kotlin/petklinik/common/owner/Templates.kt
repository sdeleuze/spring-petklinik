package petklinik.common.owner

import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.html.ButtonType
import kotlinx.html.a
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.dd
import kotlinx.html.div
import kotlinx.html.dl
import kotlinx.html.dt
import kotlinx.html.form
import kotlinx.html.h2
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.span
import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
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
                            +pet.birthDate.format(LocalDate.Formats.ISO)
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