## 2024-07-27 - Fix command injection vulnerability in hidden API calls
**Vulnerability:** The ShizukuCommandRunner was executing commands via `sh -c` passing the entire command as a single string. This opens up a classic command injection vulnerability where a caller could append `;` or `&&` and additional commands into the string.
**Learning:** Using `sh -c` with concatenated strings for command execution is unsafe. The hidden `newProcess` API in Shizuku behaves similarly to `ProcessBuilder` and accepts a string array of arguments.
**Prevention:** Always use argument arrays (e.g., `vararg command: String`) when passing commands to process execution APIs to avoid shell interpretation and command injection vulnerabilities.
