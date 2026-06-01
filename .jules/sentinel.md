## 2026-06-01 - Command Injection in Shizuku newProcess
**Vulnerability:** Shizuku `newProcess` API usage wrapped commands in `sh -c`, making it vulnerable to command injection if arguments contained unescaped characters.
**Learning:** Using shell wrappers like `sh -c` negates the safety of the `ProcessBuilder`/`newProcess` argument array separation.
**Prevention:** Always use the array/list-based execution (`List<String>`) directly with Shizuku's `newProcess` reflection API instead of shell wrappers. Cache the reflected method to maintain performance.
