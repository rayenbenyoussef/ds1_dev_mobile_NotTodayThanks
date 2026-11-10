# Not Today Thanks

## Authors
- Rayen Ben Youssef A05
- Maram Ayari A05

## Project Overview
Not Today Thanks is a playful Android app built around the idea of a time-travel travel-permit office. A traveler enters their name, birth year, destination year, and reason for traveling—tourism, changing the past, or escaping. The app checks the request, presents the details to a fictional reviewer, and lets them approve or refuse it.

Changing the past can trigger a time-paradox warning: when the year difference meets the app's prime-number check, approval is disabled. The result screen then displays the review decision. The app is a small academic project demonstrating Android screens, form validation, navigation, and simple decision logic.

## App Information
- Project name: Not Today Thanks
- Platform: Android
- Language: Java
- Architecture: Native Android app
- Build system: Gradle with Kotlin DSL

## Tech Stack and Versions
- Android Gradle Plugin (AGP): 8.13.2
- Gradle Wrapper: 8.13
- Compile SDK: 36
- Target SDK: 36
- Minimum SDK: 29
- Java compatibility: Java 11
- AppCompat: 1.8.0
- Material Components: 1.14.0
- Activity: 1.13.0
- ConstraintLayout: 2.2.2
- JUnit: 4.13.2
- AndroidX Test JUnit: 1.3.0
- Espresso Core: 3.7.0

## Tools and Technologies Used
- Android Studio — development environment for the Android app
- Java 11 — application language
- Android SDK and Android Emulator — build and run the app
- Gradle Wrapper — reproducible project builds and dependency management
- Gradle Kotlin DSL — build configuration (`.gradle.kts` files)
- Android Gradle Plugin — Android build and packaging integration
- AndroidX AppCompat and Activity — Android activity and compatibility support
- ConstraintLayout — screen layout
- Material Components — user-interface components
- JUnit — local unit testing
- AndroidX Test JUnit and Espresso — Android instrumentation and UI testing

## Main User Flow
1. Enter a name, birth year, destination year, and travel reason.
2. The app validates the required fields and checks basic travel-year constraints.
3. Review the request and its details on the verification screen.
4. Approve or refuse the request; an attempted past modification may be blocked if a paradox is detected.
5. See the decision on the result screen and return to the start.

## Project Structure
```text
NotTodayThanks/
├── app/
│   ├── src/
│   │   ├── main/       # Application source, resources, and manifest
│   │   ├── test/       # Local unit tests
│   │   └── androidTest/ # Android instrumentation tests
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── .gitignore
├── gradle/
│   ├── wrapper/
│   └── libs.versions.toml
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── gradle.properties
├── .gitignore
└── README.md
```

## Getting Started
1. Open the project in Android Studio.
2. Let Gradle sync the project dependencies.
3. Choose an emulator or connected Android device.
4. Run the app from the `app` module.

## Build Requirements
- Android Studio (latest stable version recommended)
- JDK 11 or later
- Android SDK with API level 36 configured

## Notes
This repository is a university project and is intended for academic learning and demonstration purposes.

## Contributors
- Rayen Ben Youssef
- Maram Ayari
