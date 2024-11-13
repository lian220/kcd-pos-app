plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "gradle-multi-module"

include("infra")
include("infra:feign")
include("product")
include("order")
