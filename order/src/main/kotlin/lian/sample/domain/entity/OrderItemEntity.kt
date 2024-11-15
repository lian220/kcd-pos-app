package lian.sample.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "ORDER_ITEM", schema = "order")
data class OrderItemEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ORDER_ITEM_ID")
  val orderItemId: Long = 0,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID", nullable = false)
  val order: OrderEntity,

  @Column(name = "PRODUCT_ID", nullable = false)
  val productId: Long,

  @Column(name = "QUANTITY", nullable = false)
  val quantity: Int,

  @Column(name = "UNIT_PRICE", nullable = false)
  val unitPrice: BigDecimal,

  @Column(name = "ORDER_STATUS", nullable = false)
  val orderStatus: String = "PENDING",

  @Column(name = "TOTAL_PRICE", nullable = false, insertable = false, updatable = false)
  val totalPrice: Double? = null, // Calculated column

  @Column(name = "DISCOUNT_AMOUNT", nullable = false)
  val discountAmount: Double = 0.0,

  @Column(name = "IS_DELETED", nullable = false)
  val isDeleted: Char = 'N'
)

