## 2024-05-15 - Hardcoded Keystore Credentials Removed
**Vulnerability:** Leaked `release.keystore` file in the repository root and hardcoded store and key passwords in `app/build.gradle.kts`.
**Learning:** Hardcoded secrets in source code and committing keystore files directly exposes signing credentials and potentially allows unauthorized individuals to sign applications.
**Prevention:** Always load sensitive build credentials (passwords, keystores) from non-version-controlled sources like a `keystore.properties` file or environment variables. Ensure `.gitignore` ignores `keystore.properties` and all `*.keystore`/`*.jks` files to prevent accidental leakage.
