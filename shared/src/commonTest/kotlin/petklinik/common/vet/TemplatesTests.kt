package petklinik.common.vet

import kotlin.test.Test
import kotlin.test.assertContains

class TemplatesTests {

    @Test
    fun render() {
        val vets = listOf(
            VetDto("James", "Carter", emptySet()),
            VetDto("Helen", "Leary", setOf(SpecialtyDto("radiology",1)))
        )
        val output = renderVets(vets)
        assertContains(output, "<td>James Carter</td>")
        assertContains(output, "<td>none</td>")
        assertContains(output, "<td>Helen Leary</td>")
        assertContains(output, "<td>specialty: radiology </td>")
    }
}