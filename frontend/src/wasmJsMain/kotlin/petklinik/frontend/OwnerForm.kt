package petklinik.frontend

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.serialization.json.Json
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLInputElement
import org.w3c.xhr.FormData
import petklinik.common.owner.OwnerDto
import petklinik.common.owner.renderOwnerList
import petklinik.common.owner.validateOwner

fun searchOwnerForm() {
    document.getElementById("search-owner-form")?.addEventListener("submit") { event ->
        event.preventDefault()
        val lastname = (document.getElementById("search-owner-input") as HTMLInputElement).value
        val url = if (lastname.isEmpty()) "/owners" else "/owners/$lastname"
        window.fetch(url).then { response ->
            if (response.ok) {
                response.text().then { data ->
                    val owners = Json.decodeFromString<List<OwnerDto>>(data.toString())
                    document.getElementById("owner-list")!!.innerHTML = renderOwnerList(owners)
                    null // https://github.com/Kotlin/kotlinx-browser/issues/18
                }
            }
            null // https://github.com/Kotlin/kotlinx-browser/issues/18
        }
    }
}

fun editOwnerForm() {
    document.getElementById("owner-form")?.addEventListener("submit") { event ->
        val formData = FormData(event.target as HTMLFormElement)
        val owner = OwnerDto(
            formData.get("firstName").toString(),
            formData.get("lastName").toString(),
            formData.get("address").toString(),
            formData.get("city").toString(),
            formData.get("telephone").toString(),
            emptyList(),
            formData.get("id").toString().toInt()
        )
        val validation = validateOwner(owner)
        if (!validation.isValid) {
            displayErrors(validation)
            event.preventDefault()
        }
    }
}