## 2026-05-22 - Prevent Command Injection with Shizuku newProcess
**Vulnerability:** ShizukuCommandRunner was executing commands via `sh -c` with concatenated strings, leading to potential command injection.
**Learning:** Using shell wrappers like `sh -c` with string-based execution in Shizuku's `newProcess` reflection API allows arbitrary command execution if arguments are not properly sanitized.
**Prevention:** Always use array-based execution (`List<String>`) for command arguments instead of shell wrappers when executing processes via Shizuku's reflection API.
