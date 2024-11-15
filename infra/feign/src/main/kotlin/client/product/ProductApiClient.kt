package client.product
import client.product.dto.ProductRes
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
  value = "product",
  url = "\${product.api.url}/api",
)
interface ProductApiClient {

  @GetMapping("/products/{id}")
  fun getProduct(@PathVariable id: Long): List<ProductRes>

  @GetMapping("/products")
  fun getAllProducts(
    @RequestParam("catalogId") catalogId: Long?,
    @RequestParam("productIds") productIds: List<Long>?
  ): List<ProductRes>

}
