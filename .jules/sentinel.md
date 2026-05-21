## 2024-05-21 - Remove Exposed Keystore and Hardcoded Secrets
**Vulnerability:** release.keystore was committed to the repository and build.gradle.kts contained hardcoded keystore passwords.
**Learning:** Build credentials and keystore files should never be checked into version control to prevent unauthorized app signing.
**Prevention:** Always add *.keystore, *.jks, and keystore.properties to .gitignore and load secrets from environment variables or ignored properties files.

## 2024-05-21 - Shizuku Command Injection Prevention
**Vulnerability:** Shizuku commands were executed using `sh -c` with concatenated strings, risking command injection.
**Learning:** Shell wrappers (`sh -c`) can be bypassed or abused if input is not perfectly sanitized.
**Prevention:** Use array-based command execution (`List<String>`) with Shizuku's `newProcess` API instead of shell wrappers.
