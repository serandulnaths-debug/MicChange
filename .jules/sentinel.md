## 2024-07-18 - Fix Command Injection in Shizuku Command Runner
**Vulnerability:** Command injection vulnerability in `ShizukuCommandRunner.runCommand` which used `sh -c` with a concatenated string.
**Learning:** System commands run via Shizuku (`Shizuku.newProcess`) shouldn't use a single string containing the command and arguments because an attacker might be able to craft an intent or input with shell metacharacters.
**Prevention:** Use `vararg` to pass command arguments as an array of strings (e.g., `arrayOf("appops", ...)` instead of a raw shell string) to avoid command injection vulnerabilities.
