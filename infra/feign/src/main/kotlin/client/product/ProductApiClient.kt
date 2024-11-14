package client.product
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
  value = "product",
  url = "\${product.api.url}/api",
)
interface ProductApiClient {

  @GetMapping("/products/{id}")
  fun getProduct(@PathVariable id: Long)

  @GetMapping("/products")
  fun getAllProducts()

  @GetMapping("/products/{categoryId}/category")
  fun getAllProductsByCategory(@PathVariable categoryId: Long)

}
