package lian.sample.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "OPTION_GROUP", schema = "sys")
data class OptionGroup(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OPTION_GROUP_ID")
  val id: Int,

  @Column(name = "NAME", nullable = false)
  val name: String,

  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  val createdAt: java.time.LocalDateTime = java.time.LocalDateTime.now()
)
