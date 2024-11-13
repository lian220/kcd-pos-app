package lian.sample.presentation

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lian.sample.app.ProductUseCase
import lian.sample.presentation.dto.product.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController(
  private val productUseCase: ProductUseCase
) {
  @Operation(summary = "상품 등록", description = "상품을 등록합니다.")
  @PostMapping
  fun createProduct(@RequestBody @Valid productDto: Product) =
    ResponseEntity.ok(productUseCase.createProduct(productDto))

  @Operation(summary = "상품 조회", description = "단일 상품을 조회 합니다.")
  @GetMapping("/{id}")
  fun getProduct(@PathVariable id: Long) = productUseCase.getProduct(id)

  @Operation(summary = "상품 조회", description = "전체 상품을 조회 합니다.")
  @GetMapping
  fun getAllProducts() = productUseCase.getAllProducts()

  @Operation(summary = "상품 조회", description = "카테고리 기준 전체 상품을 조회 합니다.")
  @GetMapping("/{categoryId}/category")
  fun getAllProductsByCategory(@PathVariable categoryId: Long) = productUseCase.getAllProductsByCategory(categoryId)

  @Operation(summary = "상품 수정", description = "단일 상품을 수정합니다.")
  @PutMapping("/{id}")
  fun updateProduct(@PathVariable id: Long, @RequestBody productDto: Product) =
    productUseCase.updateProduct(id, productDto)

  @Operation(summary = "상품 수정", description = "단일 상품을 삭제합니다.")
  @DeleteMapping("/{id}")
  fun deleteProduct(@PathVariable id: Long) = productUseCase.deleteProduct(id)
}