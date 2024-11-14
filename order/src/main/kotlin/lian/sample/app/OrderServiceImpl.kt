package lian.sample.app

import client.product.ProductApiClient
import lian.sample.presentation.dto.order.OrderInfo
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
  private val productApiClient: ProductApiClient,
): OrderUseCase {

  override fun createOrder(orderInfo: OrderInfo) {
    productApiClient.getProduct(1)
//    categoryRepository.findByIdOrNull(product.categoryId)
//      ?.let {
//        val optionGroup = product.optionGroupId ?. let { optionGroupRepository.findByIdOrNull(product.optionGroupId) }
//        productRepository.save(product.toEntity(null, it, optionGroup))
//      }
//      ?: throw NoSuchCategoryException("categoryId: ${product.categoryId}")
  }
}