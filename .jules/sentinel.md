## 2024-05-24 - Fix Hardcoded Keystore Secrets
**Vulnerability:** Hardcoded keystore passwords (`storePassword` and `keyPassword`) in `app/build.gradle.kts`.
**Learning:** Hardcoding secrets in build scripts exposes them to source control. In Android builds, properties can be securely loaded from a local `keystore.properties` file using `FileInputStream.use` block and fallback to `System.getenv()` for CI environments.
**Prevention:** Always externalize secrets into `.properties` files that are ignored in `.gitignore`, and provide a fallback to environment variables.
