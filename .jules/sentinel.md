## 2024-06-10 - Avoid shell wrappers in Shizuku command execution
**Vulnerability:** The code was using `sh -c` to execute a single concatenated string containing a command, making it vulnerable to command injection if variables like `packageName` were maliciously manipulated.
**Learning:** Shizuku's `newProcess` reflection API requires the command to be an array (`String[] cmd`). Wrapping it in `sh -c` bypasses the safety of argument arrays and hands a single string over to a shell parser, which re-introduces the very injection risks that array-based APIs are designed to prevent.
**Prevention:** Pass the command arguments directly as an array (e.g., via `command.toTypedArray()` from a `List<String>`) to `newProcess`, avoiding the use of `sh -c` entirely.
