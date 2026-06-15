## 2024-05-24 - Fix hardcoded credentials in build.gradle.kts
**Vulnerability:** Hardcoded keystore passwords were found in app/build.gradle.kts signingConfigs.
**Learning:** Hardcoded credentials in source control can be leaked easily. Gradle build files are often overlooked when scanning for secrets.
**Prevention:** Load secrets from an untracked properties file (e.g. keystore.properties) using FileInputStream.use { ... } and fallback to environment variables for CI/CD pipelines, ensuring these secrets are ignored in .gitignore.
