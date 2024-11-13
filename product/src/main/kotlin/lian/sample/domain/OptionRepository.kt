package lian.sample.domain

import lian.sample.domain.entity.OptionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OptionRepository: JpaRepository<OptionEntity, Long> {
}