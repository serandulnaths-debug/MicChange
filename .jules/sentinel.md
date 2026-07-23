## 2024-05-24 - Fix Command Injection in Shizuku process execution
**Vulnerability:** Constructing `sh -c` shell commands using string interpolation with unsanitized variables (like `packageName`) allows potential command injection.
**Learning:** `Shizuku.newProcess` provides the ability to pass arguments directly as a String array, avoiding the shell interpreter entirely.
**Prevention:** Pass process arguments as an array of strings rather than constructing raw shell strings.
