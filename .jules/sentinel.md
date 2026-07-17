## 2024-07-17 - Fix Command Injection Vulnerability in Shizuku Command Runner
**Vulnerability:** ShizukuCommandRunner.runCommand constructed shell commands by embedding string arguments directly into a `sh -c` string array, which is a command injection risk when passing variables.
**Learning:** Using `sh -c` with interpolated strings for executing commands via Shizuku (`newProcess`) exposes the application to command injection.
**Prevention:** Avoid `sh -c`. Pass arguments directly as a string array (`vararg command: String` mapping to `Array<String>`) to ensure arguments are treated as data, not executable code.
