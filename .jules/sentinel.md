## 2024-07-15 - Prevent Command Injection via Shizuku
**Vulnerability:** Constructing raw shell commands via `sh -c` with string interpolation for `Shizuku.newProcess` creates a critical command injection risk.
**Learning:** `Shizuku.newProcess` expects command arguments as an array. Using `sh -c` bypasses argument tokenization and exposes the application to shell metacharacter execution if any part of the command string (e.g. `packageName`) is manipulated.
**Prevention:** Always pass arguments as a string array (e.g., `vararg command: String` and cast to `Array<String>`) rather than building a single command string to be parsed by a shell.
