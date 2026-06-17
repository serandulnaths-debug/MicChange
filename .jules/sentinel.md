## 2024-05-18 - Remove Hardcoded Keystore Secrets
**Vulnerability:** Hardcoded keystore passwords and alias found in app/build.gradle.kts.
**Learning:** Hardcoding secrets exposes them in source control. Even if it's a test/release key, it establishes a bad pattern and can leak actual production credentials if reused.
**Prevention:** Always load sensitive credentials from environment variables or a local non-versioned properties file (e.g., keystore.properties added to .gitignore).
