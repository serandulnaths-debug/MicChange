## 2024-07-12 - Fix Shizuku command injection vulnerability
**Vulnerability:** Command injection in ShizukuCommandRunner via raw string passed to `sh -c`.
**Learning:** Constructing shell commands via string interpolation and passing them to `sh -c` allows arbitrary command execution if variables are manipulated or malicious.
**Prevention:** Always pass arguments to system processes as an array of strings (e.g., `arrayOf("cmd", "arg1")`) rather than a single interpolated shell string to avoid command injection vulnerabilities.
