## 2024-05-24 - Shizuku Command Injection Vulnerability
**Vulnerability:** Command Injection via Shizuku
**Learning:** Constructing raw strings and passing them to `sh -c` via Shizuku allows arbitrary command execution by malicious apps/users if input is not sanitized or constructed correctly.
**Prevention:** Avoid `sh -c` when passing commands to system components unless strictly required. Instead, use system calls (like `Runtime.exec` or hidden APIs) passing the executable and arguments as an array of strings (e.g. `vararg command: String`), ensuring arguments are safely escaped by the underlying OS API.
