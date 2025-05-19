package petklinik.backend.owner

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface PetRepository : Repository<Pet, Int> {

    @Cacheable("petTypes")
    @Transactional(readOnly = true)
    @Query("select * from pet_type order by name")
    fun findPetTypes(): List<PetType>

    @Query("select * from pet_type where id = :typeId")
    fun findPetType(@Param("typeId") id: Int): PetType

    @Transactional(readOnly = true)
    fun findById(id: Int): Pet

    @Transactional
    fun save(pet: Pet)

    @Transactional(readOnly = true)
    @Query("select * from pet where owner_id = :ownerId")
    fun findByOwnerId(@Param("ownerId") id: Int): List<Pet>
}