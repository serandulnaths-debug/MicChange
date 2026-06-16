## 2024-06-16 - Prevent hardcoded secrets in build scripts
**Vulnerability:** Hardcoded signing passwords in `app/build.gradle.kts` exposed to source control.
**Learning:** Build scripts often rely on hardcoded secrets for convenience, which compromises the app's signing keys if the repository is accessible.
**Prevention:** Load sensitive build credentials from `keystore.properties` (added to `.gitignore`) or environment variables using a helper function in `build.gradle.kts`.
