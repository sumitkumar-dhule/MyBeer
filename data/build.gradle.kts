apply {
    from("$rootDir/base-module.gradle")
}

dependencies {

    "implementation"(project(":common"))
    "implementation"(project(":domain"))

}