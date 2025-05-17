package petklinik.backend.visit

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface VisitRepository : Repository<Visit, Integer> {

    @Transactional
    fun save(visit: Visit)

    @Transactional(readOnly = true)
    @Query("select * from visit where pet_id = :petId")
    fun findByPetId(@Param("petId") petId: Int): List<Visit>

}