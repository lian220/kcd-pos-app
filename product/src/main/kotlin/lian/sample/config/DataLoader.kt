package lian.sample.config

import lian.sample.domain.CategoryRepository
import lian.sample.domain.ProductRepository
import lian.sample.domain.entity.Category
import lian.sample.domain.entity.Product
import lian.sample.domain.type.ProductStatus
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.Instant


@Component
class DataLoader(
  private val categoryRepository: CategoryRepository,
  private val productRepository: ProductRepository
) : CommandLineRunner {
  override fun run(vararg args: String?) {
    val categoryData = listOf("음료","디저트")

    for (categoryName in categoryData) {
      val category = categoryRepository.findByName(categoryName)
        ?: Category(name = categoryName).also { categoryRepository.save(it) }

      if (category.name == "음료") {
        val product = Product(
          name = "아이스 아메리카노",
          price = BigDecimal(4500),
          category = null,
          optionGroup = null,
          status = ProductStatus.AVAILABLE,
          createdAt = Instant.now(),
          updatedAt = Instant.now()
        )
        productRepository.save(product)
      }
    }

  }
}
