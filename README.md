# Kotlin Multiplatform Analytics

The Kotlin Multiplatform Analytics Library is a powerful and versatile tool designed to streamline 
the process of collecting and analyzing app data in cross-platform projects. 
It enables developers to seamlessly integrate analytics capabilities into their Kotlin-based 
applications, targeting multiple platforms such as Android, iOS, and even web applications.

# Features

The library prepared to be used in Kotlin Multiplatform projects. Currently, it supports the 
following platforms:
* Android
* TBD iOS
* TBD Web

# Integration

Add the following dependency to your `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    def githubProperties = new Properties()
    File propsFile = file("github.properties")
    if (propsFile.isFile()) {
        propsFile.withInputStream { githubProperties.load(it) }
    } else {
        githubProperties["github_username"] = System.getenv('GITHUB_USERNAME')
        githubProperties["github_password"] = System.getenv('GITHUB_PASSWORD')
    }
    repositories {
        // ...
        maven {
            url = uri("https://maven.pkg.github.com/IlyaPavlovskii/analytics")
            credentials {
                username = githubProperties["github_username"]
                password = githubProperties["github_password"]
            }
        }
    }
} 
```

If you want to fetch the library from the GitHub Packages, you need to provide your GitHub username 
and password. Connect with me and I'll generate a personal access token for you for a symbolic 
donate.

Then, add the following dependency to your `build.gradle` file:
```gradle
dependencies {
    // ...
    implementation 'io.github.ilyapavlovskii.kmm.analytics:analytics:2023.08.03'
}
```

Or, use `toml`:
```toml
[libraries]
io-github-ilyapavlovskii-kmm-analytics = { module = "io.github.ilyapavlovskii.kmm.analytics:analytics", version = "2023.08.03" }
```
and then add the following dependency to your `build.gradle` file:
```gradle
implementation libs.io.github.ilyapavlovskii.kmm.analytics
```

# How to use

Initialize your analytics tracker and put `simple` or `withParams` events:
```kotlin
private val tracker: AnalyticsTracker = AggregateAnalyticsTracker(
    LoggerAnalyticsTracker,
    FirebaseAnalyticsTracker(logger = FirebaseAnalyticsLogger.getInstance(androidContext())) 
)
tracker.trackEvent(AnalyticsEvent.Simple("SimpleEvent"))
tracker.trackEvent(AnalyticsEvent.WithParams("EventWithParams", mapOf("param1" to "value1")))
```

Firebase Analytics Tracker supports the next types as a payload events:
```kotlin
Byte,
Short,
Int,
Long,
Float,
Double,
String
```
Another types will automatically be converted to `String` type.