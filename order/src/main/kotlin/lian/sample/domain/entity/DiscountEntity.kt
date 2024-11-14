package lian.sample.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "DISCOUNT", schema = "order")
data class DiscountEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DISCOUNT_ID")
  val discountId: Long = 0,

  @Column(name = "DISCOUNT_TYPE", nullable = false)
  val discountType: String,

  @Column(name = "DISCOUNT_VALUE", nullable = false)
  val discountValue: Double
)