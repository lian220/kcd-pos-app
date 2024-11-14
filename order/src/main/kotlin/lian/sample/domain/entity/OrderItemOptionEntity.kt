package lian.sample.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "ORDER_ITEM_OPTION", schema = "order")
data class OrderItemOptionEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ORDER_ITEM_OPTION_ID")
  val orderItemOptionId: Long = 0,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ITEM_ID", nullable = false)
  val orderItem: OrderItemEntity,

  @Column(name = "OPTION_ID", nullable = false)
  val optionId: Long,

  @Column(name = "OPTION_PRICE", nullable = false)
  val optionPrice: Double = 0.0,

  @Column(name = "IS_DELETED", nullable = false)
  val isDeleted: Char = 'N'
)

