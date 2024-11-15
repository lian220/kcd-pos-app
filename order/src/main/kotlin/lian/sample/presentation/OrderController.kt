package lian.sample.presentation

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lian.sample.app.OrderUseCase
import lian.sample.presentation.dto.order.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController(
  private val productUseCase: OrderUseCase
) {
  @Operation(summary = "주문 등록", description = "주문을 등록합니다.")
  @PostMapping
  fun createProduct(@RequestBody @Valid order: Order) =
    ResponseEntity.ok(productUseCase.createOrder(order))

}