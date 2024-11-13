package lian.sample.domain

import lian.sample.domain.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long> {
  fun findByName(name: String): ProductEntity?
}