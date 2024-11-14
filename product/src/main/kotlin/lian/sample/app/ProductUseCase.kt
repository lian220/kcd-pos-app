package lian.sample.app

import lian.sample.presentation.dto.product.Product
import lian.sample.presentation.dto.product.ProductRes

interface ProductUseCase {
  fun deleteProduct(id: Long): Any
  fun updateProduct(id: Long, product: Product): Any
  fun getAllProducts(categoryId: Long?, productIds: List<Long>?): List<ProductRes>
  fun getProduct(id: Long): ProductRes
  fun createProduct(product: Product)
}