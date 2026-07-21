## 2024-05-24 - Shizuku Command Injection Risk
**Vulnerability:** System commands executed via Shizuku (`Shizuku.newProcess`) were vulnerable to command injection by constructing raw shell strings with interpolated variables (e.g., `sh -c <cmd>`).
**Learning:** Using `sh -c` with concatenated strings permits malicious inputs to break out of the command structure and execute arbitrary commands.
**Prevention:** Always pass command arguments as an array of strings (e.g., `arrayOf("appops", "set", ...)`), allowing the system to securely separate the executable from its arguments.
