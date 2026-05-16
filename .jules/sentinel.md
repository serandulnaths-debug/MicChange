## 2024-03-24 - [CRITICAL] Prevent Command Injection via Shizuku
**Vulnerability:** Shizuku command execution (`ShizukuCommandRunner.runCommand`) was using the `sh -c` shell wrapper, exposing the app to potential command injection vulnerabilities. If any of the arguments to `runCommand` (e.g. `packageName`) were externally controllable or tampered with, an attacker could execute arbitrary shell commands.
**Learning:** Shell wrappers like `sh -c` evaluate the command string in a shell context, making string concatenation for command arguments insecure.
**Prevention:** Instead of using shell wrappers and string concatenation, always pass the command and its arguments as a structured list (array-based execution) to `Shizuku.newProcess`, avoiding shell parsing entirely.
