## 2024-07-19 - Prevent Command Injection in Shizuku Calls
**Vulnerability:** `ShizukuCommandRunner` was passing commands to `sh -c` as a single raw string, which is vulnerable to command injection if variables like `packageName` are manipulated.
**Learning:** It is unsafe to construct a raw shell string with interpolated variables for `Shizuku.newProcess` execution.
**Prevention:** Always pass arguments as an array of strings (e.g., `arrayOf("cmd", "arg1", ...)`) directly to `newProcess` instead of using `sh -c` to ensure parameters are not evaluated by the shell.
