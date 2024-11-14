package lian.sample.presentation.dto.order

import java.math.BigDecimal

data class Discount(
  val discountType: String,
  val discountValue: BigDecimal
)