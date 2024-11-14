package lian.sample.presentation.dto.type

enum class OrderStatus(val type: String) {
  PENDING("결제보류"),
  COMPLETED("결제완료"),
  CANCELED("결제취소")
}