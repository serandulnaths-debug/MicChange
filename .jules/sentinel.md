## 2026-06-08 - Command Injection Risk with Shizuku newProcess API
**Vulnerability:** Command injection vulnerability identified in `ShizukuCommandRunner.kt` where unvalidated user input could potentially be passed to a shell wrapper via `arrayOf("sh", "-c", command)`.
**Learning:** Using `sh -c` to execute commands provides a shell which could interpret shell metacharacters and execute injected commands. Shizuku's `newProcess` API mimics `Runtime.getRuntime().exec` or `ProcessBuilder` and accepts arrays for command and arguments.
**Prevention:** Avoid shell wrappers like `sh -c`. Execute commands directly by passing them as a `List<String>` or `Array<String>` to the execution API. This ensures arguments are passed directly to the binary and not interpreted by a shell.
