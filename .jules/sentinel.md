## 2024-06-26 - Command Injection via Shizuku
**Vulnerability:** Shizuku command execution was vulnerable to command injection because it used `sh -c` with string interpolation.
**Learning:** Passing arrays of arguments directly to `newProcess` instead of concatenating strings prevents command injection.
**Prevention:** Always pass arguments as an array of strings to process executors, avoiding `sh -c` unless explicitly required.
