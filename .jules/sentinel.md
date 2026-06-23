## 2024-06-23 - Critical: Hardcoded Keystore Secrets
**Vulnerability:** Keystore file (`release.keystore`) was committed to version control, and its passwords were hardcoded in `app/build.gradle.kts`.
**Learning:** Hardcoding signing credentials and exposing the keystore file in the repository allows anyone with access to the repo to sign malicious APKs as the official app, compromising the supply chain.
**Prevention:** Always use environment variables or local ignored properties files (e.g., `keystore.properties`) for signing credentials. Add `*.keystore`, `*.jks`, and `keystore.properties` to `.gitignore`.
