package lian.sample.domain.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "CUSTOMER", schema = "order")
data class CustomerEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CUSTOMER_ID")
  val customerId: Long = 0,

  @Column(name = "NAME", nullable = false)
  val name: String,

  @Column(name = "PHONE", nullable = false)
  val phone: String,

  @Column(name = "EMAIL")
  val email: String? = null,

  @Column(name = "CREATED_AT", nullable = false)
  val createdAt: Instant = Instant.now()
)