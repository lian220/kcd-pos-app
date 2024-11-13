package client.product

import ClientConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(
  value = "product",
  url = "\${product.api.url}/api",
  configuration = [ClientConfiguration::class]
)
interface ProductApiClient {

  @GetMapping("/{id}")
  fun getProduct(@PathVariable id: Long)

  @GetMapping
  fun getAllProducts()

  @GetMapping("/{categoryId}/category")
  fun getAllProductsByCategory(@PathVariable categoryId: Long)

}
