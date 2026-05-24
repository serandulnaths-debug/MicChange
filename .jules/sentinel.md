## 2026-05-24 - Remove Hardcoded Keystore Secrets
**Vulnerability:** Hardcoded `storePassword` and `keyPassword` values in `app/build.gradle.kts`.
**Learning:** Hardcoding sensitive values like keystore passwords in source control exposes the app's signing keys to unauthorized users, potentially allowing them to sign and distribute malicious versions of the app. It existed because of convenience during initial setup.
**Prevention:** Always load sensitive build credentials from non-version-controlled sources like `keystore.properties`, environment variables, or Gradle project properties. Ensure these files are added to `.gitignore`.
