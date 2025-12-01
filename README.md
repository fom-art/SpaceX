# 🕵️‍♂️ SpaceX

SpaceX is a cross-platform mobile app that displays a catalog of rockets. Built with Kotlin Multiplatform (KMP), which allows to use the application on both Android and iOS devices.

---
# 🛠️ Tech stack

- **Koin** – Provides lightweight dependency injection.
- **Kotlin Multiplatform** – Enables shared business logic across platforms.
- **Compose Multiplatform** – Used for building declarative UIs across Android and iOS.
- **Ktor Client** – Used for making 

---
# 🗂️ Project structure

```
SpaceX/
├── androidApp/       # Android-specific code and resources
├── iosApp/           # iOS-specific code and resources
├── shared/           # Shared Kotlin code (business logic, models, etc.)
│   ├── app/          # Application-level shared logic
│   ├── core/         # Core utilities and abstractions
│   ├── feature/      # Modular features (e.g., roles, game setup)
├── build-logic/      # Included builds for easier dependency management
├── gradle/           # Gradle wrapper and configuration
├── .idea/            # IntelliJ IDEA project settings
├── build.gradle.kts  # Root Gradle build script
├── settings.gradle.kts
└── ...
```