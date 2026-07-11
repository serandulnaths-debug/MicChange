## 2024-07-11 - Hardcoded Keystore Secrets in build.gradle.kts
**Vulnerability:** Found hardcoded keystore passwords (`storePassword`, `keyPassword`) directly inside `app/build.gradle.kts` and the `release.keystore` file checked into source control.
**Learning:** Hardcoding credentials in build scripts and committing keystores exposes sensitive signing keys, allowing attackers to sign malicious APKs under the legitimate app's identity.
**Prevention:** Externalize secrets using `keystore.properties` or environment variables, and always add `*.keystore`, `*.jks`, and `keystore.properties` to `.gitignore`.
