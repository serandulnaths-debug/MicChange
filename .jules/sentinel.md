## 2026-05-17 - Hardcoded Keystore Credentials
**Vulnerability:** Keystore passwords were hardcoded in `app/build.gradle.kts`.
**Learning:** Hardcoding credentials directly in the build script risks credential leakage if the code repository is ever compromised or made public.
**Prevention:** Store sensitive values externally (e.g., in a non-version-controlled `keystore.properties` file or environment variables) and dynamically load them during the build process. Ensure credentials files are ignored via `.gitignore`.
