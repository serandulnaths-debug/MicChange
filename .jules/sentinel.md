## 2024-06-11 - Command Injection Vulnerability Fix
**Vulnerability:** ShizukuCommandRunner allowed executing arbitrary commands via `sh -c` wrapper using simple string concatenation.
**Learning:** Using `sh -c` with concatenated strings introduces command injection risks if the input contains shell metacharacters.
**Prevention:** Use array-based execution (`List<String>`) directly instead of shell wrappers.
