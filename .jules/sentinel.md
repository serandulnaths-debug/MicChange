## 2026-07-31 - Fix Shizuku Command Injection
**Vulnerability:** ShizukuCommandRunner passed user-controlled or variable arguments to Shizuku's hidden newProcess API via a single string executed with `sh -c`. This is a command injection risk.
**Learning:** Concatenating strings into a single `sh -c` command allows arbitrary command execution if the input is maliciously crafted.
**Prevention:** Always pass commands to `ProcessBuilder` or `Process`-like APIs as an array of individual string arguments (e.g., using `vararg` in Kotlin) rather than a single interpolated string.
