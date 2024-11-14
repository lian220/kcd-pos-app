package lian.sample.domain

import lian.sample.domain.entity.DiscountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemOptionRepository : JpaRepository<DiscountEntity, Long> {
}