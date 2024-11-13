package lian.sample.presentation

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lian.sample.app.OptironGroupUseCase
import lian.sample.presentation.dto.optionGroup.OptionGroup
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/option-groups")
class OptionGroupController(
  private val optionGroupUseCase: OptironGroupUseCase,
) {
  @Operation(summary = "옵션그룹 등록", description = "옵션그룹을 등록합니다.")
  @PostMapping
  fun createOptionGroup(@RequestBody @Valid optionGroup: OptionGroup) = optionGroupUseCase.createOptionGroup(optionGroup)
}