package lian.sample.app

import lian.sample.presentation.dto.optionGroup.OptionGroup
import lian.sample.presentation.dto.product.Product
import lian.sample.presentation.dto.product.ProductRes

interface OptironGroupUseCase {
  fun createOptionGroup(optionGroup: OptionGroup)
}