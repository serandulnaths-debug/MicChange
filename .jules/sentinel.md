## 2026-06-09 - Fix Command Injection in Shizuku Command Runner
**Vulnerability:** Command injection risk due to shell wrapper.
**Learning:** Using `sh -c` with unsanitized string commands allows command injection.
**Prevention:** Use array-based execution (`List<String>`) directly via the Shizuku reflection API.
