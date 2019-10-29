plugins {
    id("org.jetbrains.kotlin.js") version "1.3.50"
}

group = "net.sunaba.kotlin.js.with.cdn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin.target {
    useCommonJs()
    browser {
        runTask {
            archiveFileName = "bundle.js"
        }
        webpackTask {
            sourceMaps = false
            archiveFileName = "bundle.js"
        }
    }
}