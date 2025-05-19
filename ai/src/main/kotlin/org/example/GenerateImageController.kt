package org.example

import org.springframework.ai.image.ImagePrompt
import org.springframework.ai.openai.OpenAiImageModel
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GenerateImageController(
    private val model: OpenAiImageModel) {

    @GetMapping("/generate/{prompt}", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun generate(@PathVariable prompt: String): String {
        val imageResponse = model.call(ImagePrompt(prompt))
        return imageResponse.result!!.output.url
    }
}