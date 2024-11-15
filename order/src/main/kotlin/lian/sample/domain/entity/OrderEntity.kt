package lian.sample.domain.entity

import jakarta.persistence.*
import lian.sample.jpa.BooleanToYNConverter
import lian.sample.presentation.dto.order.Discount
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "`ORDER`", schema = "order")
data class OrderEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ORDER_ID")
  val orderId: Long = 0,

  @Column(name = "ORDER_DATE", nullable = false)
  val orderDate: Instant = Instant.now(),

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER_ID", nullable = false)
  val customer: CustomerEntity,

  @Column(name = "PAYMENT_TYPE", nullable = false)
  val paymentType: String,

  @Column(name = "ORDER_STATUS", nullable = false)
  val orderStatus: String = "PENDING",

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DISCOUNT_ID")
  val discount: DiscountEntity? = null,

  @Column(name = "TOTAL_AMOUNT", nullable = false)
  val totalAmount: BigDecimal,

  @Column(name = "IS_DELETED", nullable = false)
  val isDeleted: Char = 'N',

  @Column(name = "CREATED_AT", nullable = false)
  val createdAt: Instant = Instant.now(),

  @Column(name = "UPDATED_AT")
  val updatedAt: Instant? = Instant.now()
)
