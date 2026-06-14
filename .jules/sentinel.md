## 2024-06-14 - Removed Hardcoded Release Keystore Credentials
**Vulnerability:** Hardcoded `storePassword` and `keyPassword` values for the `release` signing config were found in `app/build.gradle.kts`.
**Learning:** Storing secrets in plain text in build configuration files exposes sensitive application signing keys to anyone with source code access, allowing potential impersonation or malicious updates.
**Prevention:** Use a local, non-versioned `keystore.properties` file or environment variables to inject signing credentials dynamically during the build process, and ensure credential files and keystore files are listed in `.gitignore`.
