## 2024-06-18 - Hardcoded Keystore Secrets in build.gradle.kts
**Vulnerability:** Hardcoded keystore passwords and aliases were committed directly into the `app/build.gradle.kts` file.
**Learning:** Build scripts are often overlooked as a source of secret leakage. The Gradle signingConfigs block is a common place where this occurs if environment variables or separate properties files aren't used.
**Prevention:** Always load keystore configurations dynamically using `Properties()` from a `keystore.properties` file that is gitignored, or from environment variables (e.g., `System.getenv()`).
