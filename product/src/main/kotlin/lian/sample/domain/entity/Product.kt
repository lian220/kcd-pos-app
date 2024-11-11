package lian.sample.domain.entity

import jakarta.persistence.*
import lian.sample.domain.type.ProductStatus
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "PRODUCT", schema = "sys")
data class Product(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRODUCT_ID")
  val id: Long = 0,

  @Column(name = "NAME", nullable = false)
  val name: String,

  @Column(name = "PRICE", precision = 10, scale = 2, nullable = false)
  val price: BigDecimal,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  val category: Category?,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "OPTION_GROUP_ID")
  val optionGroup: OptionGroup? = null,

  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", nullable = false)
  val status: ProductStatus = ProductStatus.AVAILABLE,

  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  val createdAt: Instant = Instant.now(),

  @Column(name = "UPDATED_AT", nullable = false)
  val updatedAt: Instant = Instant.now()
)
