## 2024-07-16 - Prevent Command Injection in Shizuku Calls
**Vulnerability:** Command injection risk when running system commands via Shizuku by interpolating variables into a single `sh -c <cmd>` string.
**Learning:** Using `sh -c` with string interpolation exposes the system to command injection. It is critical to pass arguments as an array of strings directly to the process.
**Prevention:** Always use an array of arguments (e.g., `vararg command: String`) and cast it properly when invoking hidden APIs like `Shizuku.newProcess`.
