package lian.sample.app

import client.product.dto.ProductRes
import lian.sample.exception.NoSuchProductException
import lian.sample.exception.PriceMismatchException
import lian.sample.presentation.dto.order.Order
import lian.sample.presentation.dto.order.type.DiscountType
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CalculateServiceImpl: CalculateService {
  override fun calculateProducts(order: Order, productItems: List<ProductRes>): BigDecimal {
    var totalAmount = BigDecimal(0)
    order.orderItems.forEach({orderItem ->
      productItems.find { it.id == orderItem.productId }
        ?.let {matchingProduct ->
          val productTotal = matchingProduct.price * orderItem.count.toBigDecimal()
          val optionsTotal = orderItem.options.fold(BigDecimal.ZERO) { acc, orderOption ->
            val matchingOption = matchingProduct.optionGroup?.options?.find { it.id == orderOption.optionId }
            if (matchingOption != null && matchingOption.name == orderOption.optionName && matchingOption.additionalPrice == orderOption.price) {
              acc + orderOption.price
            } else {
              acc
            }
          }

          val itemTotal = productTotal + optionsTotal
          totalAmount += itemTotal

          if (itemTotal.compareTo(orderItem.itemAmount) != 0) {
            throw PriceMismatchException("productId: ${orderItem.productId}")
          }
        } ?: let {
          throw NoSuchProductException("productId: ${orderItem.productId}")
      }
    })

    val discount = order.discount
    if (discount != null) {
      totalAmount = when (DiscountType.valueOf(discount.discountType)) {
        DiscountType.PER -> {
          val discountAmount = totalAmount.multiply(discount.discountValue).divide(BigDecimal(100), 2, RoundingMode.HALF_UP)
          totalAmount - discountAmount
        }
        DiscountType.FIX -> {
          totalAmount - discount.discountValue
        }
      }
    }

    return totalAmount.max(BigDecimal.ZERO)
  }
}