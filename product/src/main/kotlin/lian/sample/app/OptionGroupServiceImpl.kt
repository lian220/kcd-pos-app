package lian.sample.app

import com.fasterxml.jackson.databind.ObjectMapper
import lian.sample.domain.OptionGroupRepository
import lian.sample.domain.OptionRepository
import lian.sample.domain.entity.OptionEntity
import lian.sample.domain.entity.OptionGroupEntity
import lian.sample.presentation.dto.optionGroup.OptionGroup
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OptionGroupServiceImpl(
  private val optionGroupRepository: OptionGroupRepository,
  private val optionRepository: OptionRepository,
  private val objectMapper: ObjectMapper
): OptironGroupUseCase {
  @Transactional
  override fun createOptionGroup(optionGroup: OptionGroup) {
    val optionGroupEntity = optionGroupRepository.save(OptionGroupEntity(
      name = optionGroup.name,
    ))

    optionGroup.options?.forEach({option ->
      val optionEntity = OptionEntity(
        name = option.name,
        optionGroup = optionGroupEntity
      )
      optionRepository.save(optionEntity)
    })
  }
}