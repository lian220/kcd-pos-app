package lian.sample.domain.type

import lian.sample.domain.entity.DiscountEntity
import lian.sample.domain.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiscountRepository : JpaRepository<DiscountEntity, Long> {
}