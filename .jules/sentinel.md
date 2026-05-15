## 2024-05-15 - Command Injection in Shizuku Reflection
**Vulnerability:** Command injection vulnerability identified in `ShizukuCommandRunner.runCommand` due to string concatenation using `arrayOf("sh", "-c", command)`. User-supplied input inside `command` could inject arbitrary shell commands.
**Learning:** Calling Shizuku's `newProcess` reflective API via a shell (`sh -c`) evaluates variables and parameters leading to unsafe command execution.
**Prevention:** Executing processes using array-based execution (`List<String>`) circumvents the shell evaluation, making it robust against injection. Always pass arguments directly as array elements rather than concatenating them into a single string.
