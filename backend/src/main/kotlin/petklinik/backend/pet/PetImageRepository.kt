package petklinik.backend.pet

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface PetImageRepository : Repository<PetImage, Int> {

    @Transactional(readOnly = true)
    @Query("select image from pet_image where id = :petImageId")
    fun findImage(@Param("petImageId") id: Int): PetImage

    @Transactional
    fun save(image: PetImage): PetImage
}