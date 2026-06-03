## 2024-05-24 - Command Injection Risk via Shizuku Reflection API
**Vulnerability:** Execution of shell commands via Shizuku's `newProcess` hidden API using `sh -c` and string concatenation, creating a risk for command injection.
**Learning:** Using shell wrappers like `sh -c` to execute commands exposes the app to injection vulnerabilities if inputs are not sanitized. Naive string splitting (e.g., `command.split(" ")`) is also dangerous and breaks shell-specific parsing.
**Prevention:** Always execute processes via Shizuku's `newProcess` reflection API using array-based execution (`List<String>`) rather than shell wrappers. Cache reflected methods using a `lazy` property to improve performance.
