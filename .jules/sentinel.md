## 2024-06-28 - Prevent Command Injection in Shizuku Processes
**Vulnerability:** Command injection vulnerability due to passing raw shell strings (`"sh", "-c", command`) to Shizuku processes.
**Learning:** Interpolated variables in shell commands can lead to command injection.
**Prevention:** Always pass arguments to processes as an array of discrete strings (e.g., `arrayOf("appops", "set", ...)`).
