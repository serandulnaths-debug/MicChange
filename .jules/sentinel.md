## 2024-06-25 - Remove hardcoded secrets from Gradle build script
**Vulnerability:** The release keystore passwords and aliases were hardcoded as plaintext strings in the `app/build.gradle.kts` signingConfigs block.
**Learning:** Hardcoded credentials in source code pose a critical security risk as they could be leaked if the repository is compromised or shared. In Android projects, release secrets must always be kept out of version control.
**Prevention:** Extracted the secrets to be loaded dynamically from a local `keystore.properties` file (or CI environment variables) and added the properties file and standard keystore extensions to `.gitignore`.
