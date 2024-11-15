package lian.sample.presentation.dto.order

import jakarta.validation.Valid
import kr.co.mustit.validation.annotation.ValueOfEnum
import lian.sample.domain.type.ProductStatus
import lian.sample.presentation.dto.type.OrderStatus
import java.math.BigDecimal

data class Order(
  val id: Long? = null,
  val orderItems: List<OrderItem>,
  @Valid val discount: Discount?,
  @field:ValueOfEnum(enumClass = OrderStatus::class, message = "주문상태가 올바르지 않습니다.")
  val orderStatus: String,
  val totalAmount: BigDecimal = BigDecimal.ZERO,
)

data class OrderItem(
  val productId: Long,
  val productName: String,
  val orderStatus: OrderStatus,
  val count: Int,
  val itemAmount: BigDecimal,
  val options: List<OrderItemOption>
)

data class OrderItemOption (
  val optionId: Long,
  val optionName: String,
  val price: BigDecimal
)