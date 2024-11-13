package lian.sample.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "`OPTION`")
data class OptionEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OPTION_ID")
  val id: Long = 0,

  @Column(name = "NAME", nullable = false)
  val name: String,

  @Column(name = "ADDITIONAL_PRICE", precision = 10, scale = 2)
  val additionalPrice: BigDecimal = BigDecimal.ZERO,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "OPTION_GROUP_ID")
  val optionGroup: OptionGroupEntity,

  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  val createdAt: Instant = Instant.now()
)
