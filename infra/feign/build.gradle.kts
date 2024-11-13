tasks.bootJar {
  enabled = false
}

tasks.jar {
  enabled = true
}

dependencies {
  implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}