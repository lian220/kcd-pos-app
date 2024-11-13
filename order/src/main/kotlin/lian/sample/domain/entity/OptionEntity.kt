package lian.sample.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "OPTION")
data class OptionEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OPTION_ID")
  val id: Int,

  @Column(name = "NAME", nullable = false)
  val name: String,

  @Column(name = "ADDITIONAL_PRICE", precision = 10, scale = 2)
  val additionalPrice: BigDecimal = BigDecimal.ZERO,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "OPTION_GROUP_ID")
  val optionGroup: OptionGroupEntity? = null,

  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  val createdAt: java.time.LocalDateTime = java.time.LocalDateTime.now()
)
