## 2026-05-28 - Avoid shell wrappers in system process execution
**Vulnerability:** Command injection vulnerability via `sh -c` shell wrapper in Shizuku's `newProcess` execution.
**Learning:** Using shell wrappers like `sh -c` with string commands (especially those containing dynamic input like package names) introduces command injection risks, as the shell will interpret shell metacharacters in the input.
**Prevention:** Always use array-based execution (`List<String>`) for system processes to pass arguments directly to the executable without involving a shell interpreter.
