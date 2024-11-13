description = "product module"

dependencies {
  implementation("org.springframework.boot:spring-boot-devtools")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.5")

  runtimeOnly("com.mysql:mysql-connector-j")

  api("com.querydsl:querydsl-jpa:5.0.0:jakarta")
  kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
  annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jakarta")

  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
  implementation(project(":core"))
}