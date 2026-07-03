## 2024-07-03 - Hardcoded Command Execution and Credentials
**Vulnerability:** Command injection vulnerability in `ShizukuCommandRunner.runCommand` due to passing raw shell commands (`sh -c <cmd>`). Also, hardcoded keystore credentials in `app/build.gradle.kts`.
**Learning:** `Shizuku.newProcess` should accept a pre-tokenized array of strings to avoid shell interpretation vulnerabilities. Build files must not check in plain text credentials.
**Prevention:** Use `Array<String>` instead of raw string commands for Shizuku process calls. Load sensitive properties dynamically using `keystore.properties` and add `.gitignore` coverage.
