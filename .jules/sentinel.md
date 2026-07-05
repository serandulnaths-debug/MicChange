## 2024-07-05 - Fix Command Injection in ShizukuCommandRunner
**Vulnerability:** ShizukuCommandRunner executed raw shell commands (`sh -c`) constructed with interpolated strings, leading to command injection risks.
**Learning:** Passing arguments as a single raw shell string exposes the application to command injection.
**Prevention:** Always pass arguments as an array of strings (e.g., `arrayOf("cmd", "arg")`) to command runners instead of constructing a single shell string.
