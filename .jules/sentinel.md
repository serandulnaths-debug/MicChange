
## 2024-05-24 - Prevent Command Injection via Shizuku
**Vulnerability:** Shizuku command execution used `sh -c` wrapper with unescaped string concatenation, allowing for command injection.
**Learning:** Using `sh -c` introduces vulnerabilities by parsing complex shell commands. Array-based execution via `List<String>` prevents shell-specific parsing and ensures safe command execution. Reflected methods should also be cached for performance.
**Prevention:** Use array-based execution (`List<String>`) for shell commands instead of string concatenation with `sh -c`.
