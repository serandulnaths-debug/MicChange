## 2024-08-01 - Command Injection in Shizuku Command Runner
**Vulnerability:** ShizukuCommandRunner passed user-influenced strings (like package name) to a `sh -c` shell execution, opening a path for command injection.
**Learning:** Executing system commands via Shizuku's hidden API by concatenating strings for the shell introduces command injection risks, even for seemingly safe inputs like package names.
**Prevention:** Use an array of individual string arguments (e.g., using `vararg`) rather than a single concatenated string, ensuring parameters are passed directly to the executable without shell interpolation.
