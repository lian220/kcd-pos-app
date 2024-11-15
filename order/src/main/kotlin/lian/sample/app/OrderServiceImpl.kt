package lian.sample.app

import client.product.ProductApiClient
import lian.sample.domain.OrderItemOptionRepository
import lian.sample.domain.OrderItemRepository
import lian.sample.domain.OrderRepository
import lian.sample.domain.entity.*
import lian.sample.domain.type.DiscountRepository
import lian.sample.exception.PriceMismatchException
import lian.sample.presentation.dto.order.Order
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class OrderServiceImpl(
  private val productApiClient: ProductApiClient,
  private val calculateService: CalculateService,
  private val discountRepository: DiscountRepository,
  private val orderRepository: OrderRepository,
  private val orderItemRepository: OrderItemRepository,
  private val orderItemOptionRepository: OrderItemOptionRepository
): OrderUseCase {

  override fun createOrder(order: Order) {
    val productItems = productApiClient.getAllProducts(null, order.orderItems.map { it.productId })
    val totalAmount = calculateService.calculateProducts(order, productItems)
    if(totalAmount.compareTo(order.totalAmount) != 0) {
      throw PriceMismatchException("상품 가격이 일치하지 않습니다.")
    }
    saveOrder(order)
  }

  @Transactional
  fun saveOrder(data: Order) {
    val discount = data.discount?.let {
      discountRepository.save(DiscountEntity(discountType = it.discountType,discountValue = it.discountValue))
    }

    val order = orderRepository.save(
      OrderEntity(
        customer = CustomerEntity(1, "01011112222", "lian@gmail.com"),
        paymentType = "CARD",
        orderStatus = data.orderStatus,
        totalAmount = data.totalAmount,
        discount = discount
      )
    )

    data.orderItems.map { item ->
      val orderItem =
        orderItemRepository.save(
          OrderItemEntity(
            order = order,
            productId = item.productId,
            quantity = item.count,
            unitPrice = item.itemAmount / item.count.toBigDecimal(),
            orderStatus = item.orderStatus.toString(),
          )
        )

      item.options.map { option ->
        val orderItemOption = OrderItemOptionEntity(
          orderItem = orderItem,
          optionId = option.optionId,
          optionPrice = option.price
        )
        orderItemOptionRepository.save(orderItemOption)
      }
    }
  }
}