plugins {
  id("org.jetbrains.kotlin.jvm") version "1.8.10"

  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jre8:1.2.71")
  compileOnly("io.reactivex.rxjava2:rxkotlin:2.4.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
  implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
  implementation("io.projectreactor:reactor-core:3.5.7")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
}


tasks.named<Test>("test") {
  useJUnitPlatform()
}
