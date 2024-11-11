package lian.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableAsync


@SpringBootApplication
@EnableJpaAuditing
@EnableAsync(proxyTargetClass = true)
@ComponentScan(basePackages = ["lian.sample.domain", "lian.sample.config"])
class ProductApplication

fun main(args: Array<String>) {
  runApplication<ProductApplication>(*args)
}