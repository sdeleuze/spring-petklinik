package petklinik.frontend

import io.konform.validation.ValidationResult
import kotlinx.browser.window

fun displayErrors(validation: ValidationResult<*>) {
    val stringBuilder = StringBuilder()
    stringBuilder.append("${validation.errors.size} errors:\n")
    for (error in validation.errors) {
        stringBuilder.append("${error.dataPath.substring(1).replaceFirstChar { it.titlecase() }}: ${error.message}\n")
    }
    window.alert(stringBuilder.toString())
}
