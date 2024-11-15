package lian.sample.domain

import lian.sample.domain.entity.DiscountEntity
import lian.sample.domain.entity.OrderItemOptionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemOptionRepository : JpaRepository<OrderItemOptionEntity, Long> {
}