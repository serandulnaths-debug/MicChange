## 2024-07-22 - Fix Command Injection in Shizuku newProcess
**Vulnerability:** The ShizukuCommandRunner used string interpolation to execute shell commands (`sh -c "$command"`), making it vulnerable to command injection if malicious input was provided.
**Learning:** System commands should avoid passing raw shell strings.
**Prevention:** Always use process arguments arrays (e.g., `arrayOf("cmd", "arg1")`) instead of shell command strings when using `Shizuku.newProcess()`.
