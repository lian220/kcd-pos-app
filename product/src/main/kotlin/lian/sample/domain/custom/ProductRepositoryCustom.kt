package lian.sample.domain.custom

import lian.sample.presentation.dto.product.ProductRes

interface ProductRepositoryCustom {
  fun findAllBySearchCondition(categoryId: Long?): List<ProductRes>
}