plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("com.google.cloud:spring-cloud-gcp-starter-sql-mysql:4.8.1")
//	implementation("com.google.cloud.sql:mysql-socket-factory-connector-j-8:1.1.0")

	//spring security and JWT
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.auth0:java-jwt:4.4.0")
	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	implementation("io.jsonwebtoken:jjwt-jackson:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")


	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
	implementation("com.google.firebase:firebase-admin:9.4.1")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
