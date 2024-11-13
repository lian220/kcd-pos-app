package lian.sample.app

import com.fasterxml.jackson.databind.ObjectMapper
import lian.sample.domain.CategoryRepository
import lian.sample.domain.OptionGroupRepository
import lian.sample.domain.ProductRepository
import lian.sample.domain.entity.ProductEntity
import lian.sample.exception.NoSuchCategoryException
import lian.sample.exception.NoSuchProductException
import lian.sample.presentation.dto.category.Category
import lian.sample.presentation.dto.optionGroup.OptionGroup
import lian.sample.presentation.dto.product.Product
import lian.sample.presentation.dto.product.ProductRes
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl(
  private val productRepository: ProductRepository,
  private val categoryRepository: CategoryRepository,
  private val optionGroupRepository: OptionGroupRepository,
  private val objectMapper: ObjectMapper
): ProductUseCase {

  override fun createProduct(product: Product) {
    categoryRepository.findByIdOrNull(product.categoryId)
      ?.let {
        val optionGroup = product.optionGroupId ?. let { optionGroupRepository.findByIdOrNull(product.optionGroupId) }
        productRepository.save(product.toEntity(null, it, optionGroup))
      }
      ?: throw NoSuchCategoryException("categoryId: ${product.categoryId}")
  }

  @Transactional(readOnly = true)
  override fun getProduct(id: Long): ProductRes {
    return productRepository.findByIdOrNull(id)
      ?.let { convertEntityToProduct(it) }
      ?: throw NoSuchProductException("productId: ${id}")
  }

  private fun convertEntityToProduct(product: ProductEntity): ProductRes {
    val category = objectMapper.convertValue(product.categoryEntity, Category::class.java)
    val optionGroup = product.optionGroup?.let { objectMapper.convertValue(product.optionGroup, OptionGroup::class.java) }
    return ProductRes(
      id = product.id,
      name = product.name,
      price = product.price,
      color = product.color,
      category = category,
      optionGroup = optionGroup,
      isTaxIncluded = product.isTaxIncluded,
      status = product.status
    )
  }

  override fun getAllProductsByCategory(categoryId: Long): List<Product> {
    TODO("Not yet implemented")
  }

  override fun getAllProducts(): List<Product> {
    TODO("Not yet implemented")
  }

  override fun deleteProduct(id: Long): Any {
    TODO("Not yet implemented")
  }

  override fun updateProduct(id: Long, product: Product): Any {
    TODO("Not yet implemented")
  }
}