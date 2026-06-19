## 2026-06-19 - Secure Keystore Properties Loading
**Vulnerability:** Hardcoded keystore secrets and passwords were found in app/build.gradle.kts.
**Learning:** Hardcoded credentials in build files are tracked in source control, posing a critical security risk. A reusable pattern involves reading credentials from a git-ignored keystore.properties file using a secure fallback chain (java.util.Properties with System.getenv).
**Prevention:** Always use a keystore.properties file or environment variables for signing configurations. Ensure *.keystore and properties files are listed in .gitignore.
