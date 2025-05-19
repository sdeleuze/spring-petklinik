package petklinik.frontend

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLFormElement
import org.w3c.xhr.FormData
import petklinik.common.owner.PetDto
import petklinik.common.owner.PetTypeDto
import petklinik.common.owner.validatePet

fun addPetForm() {
    document.getElementById("pet-form")?.addEventListener("submit") { event ->
        val formData = FormData(event.target as HTMLFormElement)
        val pet = PetDto(
            formData.get("name").toString(),
            formData.get("birthDate").toString(),
            PetTypeDto("", formData.get("typeId").toString().toInt())
        )
        val validation = validatePet(pet)
        if (!validation.isValid) {
            val stringBuilder = StringBuilder()
            stringBuilder.append("${validation.errors.size} errors:\n")
            for (error in validation.errors) {
                stringBuilder.append("${error.dataPath.substring(1).replaceFirstChar { it.titlecase() }}: ${error.message}\n")
            }
            window.alert(stringBuilder.toString())
            event.preventDefault()
        }
    }
}