plugins {
    `java-library`
    `azure-maven`
    project
}

subprojects {
    apply(plugin = "java-library")

    group = "com.foodtruck"
    version = "1.0.0"

    repositories {
        maven {
            url = uri("https://neowu.github.io/maven-repo/")
            content {
                includeGroupByRegex("core\\.framework.*")
            }
        }
        google()
        mavenCentral()
    }

    configure(subprojects.filter { (it.name.endsWith("-interface")) }) {
        java {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    dependencies {
        implementation(platform("com.wonder:wonder-dependencies:3.0.+"))
    }
}

configure(subprojects.filter { it.name.endsWith("-db-migration") }) {
    apply(plugin = "db-migration")

    dependencies {
        runtimeOnly("com.mysql:mysql-connector-j")
    }
}

configure(subprojects.filter { it.name.endsWith("-mongo-migration") }) {
    apply(plugin = "app")
    // add here
    apply(plugin = "mongo-migration")
    dependencies {
        implementation("com.wonder:core-ng")
        implementation("com.wonder:core-ng-mongo")
        implementation("com.wonder:core-ext-mongo-migration")
    }
}

configure(subprojects.filter { (it.name.endsWith("-interface") || it.name.endsWith("-interface-v2")) }) {
    apply(plugin = "lib")
    dependencies {
        implementation("com.wonder:core-ng-api")
    }
}

configure(subprojects.filter { it.name.endsWith("-service") }) {
    apply(plugin = "app")
    dependencies {
        "implementation"("com.wonder:core-ng")
        "testImplementation"("com.wonder:core-ng-test")
        "implementation"("com.wonder:core-ext-open-api")
        "runtimeOnly"("com.mysql:mysql-connector-j")
        "testRuntimeOnly"("org.hsqldb:hsqldb")
    }
}

// services use db
configure(
    listOf(
        project(":backend:meeting-room-service")
    )
) {
    dependencies {
        runtimeOnly("com.mysql:mysql-connector-j")
        testRuntimeOnly("org.hsqldb:hsqldb")
    }
}

// services use mongodb
configure(
    listOf(
        project(":backend:meeting-room-service")
    )
) {
    dependencies {
        implementation(platform("com.wonder:wonder-dependencies:3.0.+"))
        implementation("com.wonder:core-ng-mongo")
        testImplementation("com.wonder:core-ng-mongo-test")
    }
}

project("backend:meeting-room-service") {
    dependencies {
        "implementation"(project(":backend:meeting-room-service-interface"))
    }
}
