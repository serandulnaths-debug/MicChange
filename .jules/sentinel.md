## 2024-07-26 - Fix Shizuku Command Injection
**Vulnerability:** Shell command injection vulnerability via Shizuku command execution (`arrayOf("sh", "-c", command)`).
**Learning:** Using `sh -c` with unsanitized string input allows command injection. Shizuku's `newProcess` API natively supports array-based arguments, mitigating this risk.
**Prevention:** Always pass commands as individual arguments (e.g. `vararg command: String`) directly to the process execution API instead of wrapping them in a shell execution environment.
