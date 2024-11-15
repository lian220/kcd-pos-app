package lian.sample.presentation.dto.order

import kr.co.mustit.validation.annotation.ValueOfEnum
import lian.sample.presentation.dto.order.type.DiscountType
import java.math.BigDecimal

data class Discount(
  @field:ValueOfEnum(enumClass = DiscountType::class, message = "상품 상태가 올바르지 않습니다.")
  val discountType: String,
  val discountValue: BigDecimal
)