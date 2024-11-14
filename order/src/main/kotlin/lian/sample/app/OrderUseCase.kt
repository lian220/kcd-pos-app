package lian.sample.app

import lian.sample.presentation.dto.order.OrderInfo

interface OrderUseCase {
  fun createOrder(orderInfo: OrderInfo)
}