plugins {
  id("org.jetbrains.kotlin.jvm") version "1.8.10"

  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jre8:1.2.71")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
  testImplementation("junit:junit:4.13.2")
  testImplementation("io.kotest:kotest-property-jvm:5.7.2")

}


tasks.named<Test>("test") {
  useJUnitPlatform()
}
