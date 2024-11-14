package lian.sample.presentation.dto.order

import lian.sample.presentation.dto.type.OrderStatus
import java.math.BigDecimal

data class Order(
  val id: Long? = null,
  val orderItems: List<OrderItem>
)

data class OrderItem(
  val productId: Long,
  val productName: String,
  val orderStatus: OrderStatus,
  val count: Int,
  val amount: BigDecimal,
  val options: List<OrderItemOption>
)

data class OrderItemOption (
  val optionId: Long,
  val optionName: String,
  val amount: BigDecimal
)