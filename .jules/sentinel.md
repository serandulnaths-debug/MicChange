## 2024-07-30 - Fix Command Injection in ShizukuCommandRunner
**Vulnerability:** The application used `sh -c` with concatenated strings for executing system commands via Shizuku, making it vulnerable to command injection if malicious input was passed to `runCommand`.
**Learning:** Concatenating commands for `sh -c` is a common pattern that introduces command injection risks in Android apps utilizing Shizuku. Passing an array of arguments directly to the process builder is more secure.
**Prevention:** Always pass commands as arrays of individual arguments (e.g., using `vararg`) rather than string concatenation, avoiding `sh -c` altogether.
