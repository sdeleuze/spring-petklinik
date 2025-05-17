package petklinik.backend.vet

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface SpecialtyRepository : Repository<Specialty, Int> {

    @Cacheable("specialty")
    @Transactional(readOnly = true)
    fun findById(id: Int): Specialty
}