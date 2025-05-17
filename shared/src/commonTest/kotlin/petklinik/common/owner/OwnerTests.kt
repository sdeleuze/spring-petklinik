package petklinik.common.owner

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OwnerTests {

    @Test
    fun valid() {
        val owner = OwnerDto("George", "Franklin", "110 W. Liberty St.", "Madison", "6085551023", emptyList())
        assertTrue(validateOwner(owner).isValid)
    }

    @Test
    fun emptyFirstname() {
        val owner = OwnerDto("", "Franklin", "110 W. Liberty St.", "Madison", "6085551023", emptyList())
        assertFalse(validateOwner(owner).isValid)
    }

    @Test
    fun emptyLastname() {
        val owner = OwnerDto("George", "", "110 W. Liberty St.", "Madison", "6085551023", emptyList())
        assertFalse(validateOwner(owner).isValid)
    }

    @Test
    fun emptyAddress() {
        val owner = OwnerDto("George", "Franklin", "", "Madison", "6085551023", emptyList())
        assertFalse(validateOwner(owner).isValid)
    }

    @Test
    fun emptyCity() {
        val owner = OwnerDto("George", "Franklin", "110 W. Liberty St.", "", "6085551023", emptyList())
        assertFalse(validateOwner(owner).isValid)
    }

    @Test
    fun shorterTelephone() {
        val owner = OwnerDto("George", "Franklin", "110 W. Liberty St.", "Madison", "6", emptyList())
        assertFalse(validateOwner(owner).isValid)
    }

    @Test
    fun longerTelephone() {
        val owner = OwnerDto("George", "Franklin", "110 W. Liberty St.", "Madison", "60855510232", emptyList())
        assertFalse(validateOwner(owner).isValid)
    }
}