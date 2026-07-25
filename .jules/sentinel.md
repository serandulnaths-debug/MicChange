## 2024-07-25 - Prevent Command Injection in Shizuku
**Vulnerability:** ShizukuCommandRunner wrapped arbitrary string commands in `sh -c`, risking command injection.
**Learning:** Running system commands via Shizuku (`Shizuku.newProcess`) should avoid string interpolation.
**Prevention:** Pass arguments as an array of strings (`vararg command: String`) rather than constructing a single raw shell string.
