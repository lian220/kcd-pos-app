package lian.sample.domain

import lian.sample.domain.entity.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemRepository: JpaRepository<OrderItemEntity, Long> {
}