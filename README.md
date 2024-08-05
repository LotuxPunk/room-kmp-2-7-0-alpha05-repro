# Room KMP -  Issue reporting - 2.7.0-alpha05

```
> Task :shared:compileKotlinIosSimulatorArm64
Failed to load native library:libjansi.jnilib. The native library file at /Users/lotuxpunk/.gradle/native/jansi/1.18/osx/libjansi.jnilib is not executable, make sure that the directory is mounted on a partition without the noexec flag, or set the jansi.tmpdir system property to point to a proper location.  osinfo: Mac/arm64
java.lang.UnsatisfiedLinkError: /Users/lotuxpunk/.gradle/native/jansi/1.18/osx/libjansi.jnilib: dlopen(/Users/lotuxpunk/.gradle/native/jansi/1.18/osx/libjansi.jnilib, 0x0001): tried: '/Users/lotuxpunk/.gradle/native/jansi/1.18/osx/libjansi.jnilib' (mach-o file, but is an incompatible architecture (have 'x86_64', need 'arm64e' or 'arm64')), '/System/Volumes/Preboot/Cryptexes/OS/Users/lotuxpunk/.gradle/native/jansi/1.18/osx/libjansi.jnilib' (no such file), '/Users/lotuxpunk/.gradle/native/jansi/1.18/osx/libjansi.jnilib' (mach-o file, but is an incompatible architecture (have 'x86_64', need 'arm64e' or 'arm64'))
/Users/lotuxpunk/AndroidStudioProjects/Morsel/shared/build/generated/ksp/metadata/commonMain/kotlin/database/AppDatabase_Impl.kt:35:14: error: Redeclaration:
@Suppress(...) class AppDatabase_Impl : AppDatabase
/Users/lotuxpunk/AndroidStudioProjects/Morsel/shared/build/generated/ksp/metadata/commonMain/kotlin/database/AppDatabase_InstantiateImpl.kt:5:1: error: Conflicting overloads:
fun KClass<AppDatabase>.instantiateImpl(): AppDatabase
/Users/lotuxpunk/AndroidStudioProjects/Morsel/shared/build/generated/ksp/metadata/commonMain/kotlin/database/dao/IngredientDao_Impl.kt:15:14: error: Redeclaration:
@Suppress(...) class IngredientDao_Impl : IngredientDao
/Users/lotuxpunk/AndroidStudioProjects/Morsel/shared/build/generated/ksp/metadata/commonMain/kotlin/database/dao/RecipeDao_Impl.kt:35:14: error: Redeclaration:
@Suppress(...) class RecipeDao_Impl : RecipeDao
/Users/lotuxpunk/AndroidStudioProjects/Morsel/shared/build/generated/ksp/metadata/commonMain/kotlin/database/dao/RecipeIngredientDao_Impl.kt:15:14: error: Redeclaration:
@Suppress(...) class RecipeIngredientDao_Impl : RecipeIngredientDao
/Users/lotuxpunk/AndroidStudioProjects/Morsel/shared/build/generated/ksp/metadata/commonMain/kotlin/database/dao/RecipeStepDao_Impl.kt:15:14: error: Redeclaration:
@Suppress(...) class RecipeStepDao_Impl : RecipeStepDao
```

----------

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
