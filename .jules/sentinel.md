## 2024-06-20 - Remove hardcoded keystore secrets
**Vulnerability:** Hardcoded keystore passwords and aliases in `app/build.gradle.kts`.
**Learning:** Hardcoding sensitive values in build scripts exposes them to anyone with repository access. These should be dynamically loaded.
**Prevention:** Use a `keystore.properties` file locally (git-ignored) and environment variables for CI to provide secrets dynamically at build time. Always check build files for hardcoded secrets.
