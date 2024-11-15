package lian.sample.app

import client.product.dto.ProductRes
import lian.sample.presentation.dto.order.Order
import java.math.BigDecimal

interface CalculateService {
  fun calculateProducts(order: Order, productItems: List<ProductRes>): BigDecimal
}