plugins {
    project
    publish
    `java-library`
    `azure-maven`
}

val commonInterfaceVersion = "19.7.0"
val commonLibraryVersion = "11.4.0"
val consumerDeliveryZoneServiceInterfaceVersion = "2.0.0"
val customerServiceInterfaceVersion = "72.0.0"
val customerSurveyServiceInterface = "10.1.0"
val customerWalletServiceInterfaceVersion = "20.2.0"
//var enhancedApiClientLibraryVersion = "0.0.21"
val forterIntegrationServiceVersion = "3.5.0"
val wonderProtoVersion = "1.111.0"
var fulfillmentServiceInterfaceVersion = "21.1.0"
var giftCardOrderServiceInterfaceVersion = "9.4.0"
val imageServiceInterfaceVersion = "3.0.0"
var kitchenManagementServiceInterfaceVersion = "27.4.0"
val marketingServiceInterfaceVersion = "53.0.0"
val mapLibraryVersion = "5.3.3"
val mparticleLibraryVersion = "0.1.1"
val orderNumberServiceInterfaceVersion = "1.1.0"
val orderSearchServiceInterfaceVersion = "9.2.0"
val orderServiceInterfaceVersion = "124.1.2"
val paymentServiceInterfaceVersion = "15.0.0"
val recipeServiceV2InterfaceVersion = "32.1.0"
val restaurantRecommendationServiceInterfaceVersion = "9.1.0"
val restaurantServiceInterfaceVersion = "92.1.0"
val searchServiceInterfaceVersion = "56.3.0"
val shippingAPIVersion = "4.0.0" // dev only for FR shipment si mulation
val shippingServiceInterfaceVersion = "11.2.0"
val taxServiceVersion = "7.2.0"
val userServiceInterfaceVersion = "3.5.0"
var wonderCartServiceInterfaceVersion = "38.1.0"
val wonderSettingServiceInterfaceVersion = "54.0.0"
val zendeskIntegrationServiceInterface = "16.0.0"
val csaProtectionLibraryVersion = "0.0.2"

val azureIdentityVersion = "1.18.2"
val azureEventHubVersion = "5.21.3"
val azureEventHubCheckpointVersion = "1.21.3"
var grpcVersion = "1.79.0"
val googleClientVersion = "2.9.0"
val sshjVersion = "0.40.0"
val icu4jVersion = "78.2"
val protoBufVersion = "4.33.5"
val jjwtVersion = "0.13.0"
val postgresqlVersion = "42.7.7"
val opencsvVersion = "5.12.0"

subprojects {
    group = "com.foodtruck"
    version = "1.0.0"

    repositories {
        maven {
            url = uri("https://maven.fury.io/blueapron")
            authentication {
                create<BasicAuthentication>("basic")
            }
            credentials {
                username = System.getenv("FURY_TOKEN")
                password = ""
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

    if (!plugins.hasPlugin("java")) {
        return@subprojects
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

configure(subprojects.filter { (it.name.endsWith("-interface") || it.name.endsWith("-interface-v2")) }) {
    apply(plugin = "lib")
    dependencies {
        implementation("com.wonder:core-ng-api")
    }
}

configure(listOf(
        project("utility:common"),
        project("utility:logging-lib"),
        project("utility:eventhub-lib"),
        project("utility:executor-lib"),
        project("utility:core-async-lib"),
        project("utility:enhanced-api-client-library")
    )) {
    apply(plugin = "lib")
    dependencies {
        implementation("com.wonder:core-ng")
        testImplementation("com.wonder:core-ng-test")
        testRuntimeOnly("org.hsqldb:hsqldb")
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

configure(subprojects.filter {
    (it.name.endsWith("-service") || it.name.endsWith("-site") || it.name.endsWith("-api"))
}) {
    apply(plugin = "app")
    dependencies {
        implementation("com.wonder:core-ng")
        testImplementation("com.wonder:core-ng-test")
        implementation(project(":utility:common"))
        implementation("com.wonder:core-ext-open-api")
    }
}