## 2024-05-24 - Fix command injection in ShizukuCommandRunner
**Vulnerability:** Command injection risk via string interpolation in Shizuku `newProcess` wrapper.
**Learning:** Using `sh -c` with a single interpolated string for command execution risks command injection, especially with dynamic properties like package names, allowing attackers to execute arbitrary shell commands under Shizuku's elevated privileges.
**Prevention:** Always pass command arguments as separate elements in a string array directly to the process builder rather than relying on a shell to parse a single string.
