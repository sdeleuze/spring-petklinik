package petklinik.backend.owner

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface OwnerRepository : Repository<Owner, Int> {

    @Cacheable("owners")
    @Transactional(readOnly = true)
    @Query("select * from owner order by id desc")
    fun findAll(): List<Owner>

    @Transactional(readOnly = true)
    @Query("SELECT * FROM owner WHERE last_name LIKE concat(:lastName,'%')")
    fun findByLastName(@Param("lastName") lastName: String): Collection<Owner>

    @Transactional(readOnly = true)
    fun findById(@Param("id") id: Int): Owner

    @Transactional
    fun save(owner: Owner)

}