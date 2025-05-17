import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.serialization.json.Json
import org.w3c.dom.HTMLInputElement
import petklinik.common.owner.OwnerDto
import petklinik.common.owner.renderOwnerList

fun main() {
    document.getElementById("search-owner-form")!!.addEventListener("submit") { event ->
        event.preventDefault()
        val lastname = (document.getElementById("search-owner-input") as HTMLInputElement).value
        val url = if (lastname.isEmpty()) "/owners" else "/owners/$lastname"
        window.fetch(url).then { response ->
            if (response.ok) {
               response.text().then { data ->
                    val owners = Json.decodeFromString<List<OwnerDto>>(data.toString())
                    document.getElementById("owner-list")!!.innerHTML = renderOwnerList(owners)
                    null
                }
            }
            null
        }
    }
}

