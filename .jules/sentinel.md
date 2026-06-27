## 2024-05-30 - Remove hardcoded keystore passwords from build script
**Vulnerability:** Hardcoded keystore passwords (`password`) were found in plaintext in `app/build.gradle.kts`.
**Learning:** Hardcoding secrets in build scripts exposes them in source control history and violates the principle of least privilege.
**Prevention:** Use a `keystore.properties` file (ignored by `.gitignore`) or environment variables to inject secrets into the build script securely.
