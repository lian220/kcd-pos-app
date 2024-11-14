package lian.sample.presentation.dto.order

import lian.sample.presentation.dto.type.OrderStatus
import java.math.BigDecimal

class OrderInfo(
  val orders: List<Order>,
  val discount: Discount?,
  val orderStatus: OrderStatus,
  val totalAmount: BigDecimal = BigDecimal.ZERO,
)