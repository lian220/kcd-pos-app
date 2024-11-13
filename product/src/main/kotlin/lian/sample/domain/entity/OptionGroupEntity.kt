package lian.sample.domain.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "OPTION_GROUP")
data class OptionGroupEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OPTION_GROUP_ID")
  val id: Int,

  @Column(name = "NAME", nullable = false)
  val name: String,

  @Column(name = "IS_REQUIRED", length = 1, nullable = false, columnDefinition = "CHAR(1) DEFAULT 'Y'")
  val isRequired: String = "Y",

  @Column(name = "MIN_COUNT", nullable = false, columnDefinition = "INT UNSIGNED DEFAULT 1")
  val minCount: Int = 1,

  @Column(name = "MAX_COUNT", nullable = false, columnDefinition = "INT UNSIGNED DEFAULT 1")
  val maxCount: Int = 1,

  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  val createdAt: Instant = Instant.now(),
)
