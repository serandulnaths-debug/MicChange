## 2024-05-15 - Command Injection Mitigation in Shizuku
**Vulnerability:** Shizuku command execution was using `sh -c` with concatenated strings, opening up the risk for command injection.
**Learning:** `Shizuku.newProcess` supports passing arrays of commands directly, avoiding string evaluation by a shell.
**Prevention:** Always pass arguments as an array to `Shizuku.newProcess` instead of concatenating them in `sh -c`.
