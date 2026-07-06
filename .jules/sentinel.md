## 2026-07-06 - Command Injection via Shizuku
**Vulnerability:** Command Injection risk in `Shizuku.newProcess` by passing unsanitized strings to `sh -c`.
**Learning:** Constructing single shell strings with interpolated variables (like `$packageName`) allows potential attackers to execute arbitrary shell commands if variables are manipulated.
**Prevention:** Pass arguments as an array of strings (e.g., `vararg command: String` and `arrayOf(*command)`) to `Shizuku.newProcess` to prevent shell metacharacter interpretation.
