package petklinik.backend.vet

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface VetRepository : Repository<Vet, Int> {

    @Cacheable("vets")
    @Transactional(readOnly = true)
    @Query("select * from vet order by id desc")
    fun findAll(): List<Vet>
}