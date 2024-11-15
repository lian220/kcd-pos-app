package lian.sample.app

import lian.sample.presentation.dto.order.Order

interface OrderUseCase {
  fun createOrder(order: Order)
}