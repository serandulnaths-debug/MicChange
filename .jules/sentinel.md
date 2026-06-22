## 2024-05-24 - Removed hardcoded keystore secrets
**Vulnerability:** Hardcoded keystore passwords and aliases in app/build.gradle.kts
**Learning:** Hardcoding credentials in build scripts risks committing sensitive information to version control, leading to unauthorized signing.
**Prevention:** Always load sensitive credentials dynamically from a local, git-ignored properties file (e.g., keystore.properties) or environment variables.
