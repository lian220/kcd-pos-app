package client.product.dto

data class SearchConditionDto(
  val categoryId: Long? = null,
  val productIds: List<Long>? = null
)