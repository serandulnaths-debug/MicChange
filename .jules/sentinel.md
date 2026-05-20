## 2024-05-24 - Command Injection via Shizuku shell wrappers
**Vulnerability:** The Shizuku command runner passed unsanitized string commands to a shell using `arrayOf("sh", "-c", command)`. This creates a severe command injection risk if any portion of the command string is attacker-controlled.
**Learning:** Shell wrappers like `sh -c` parse strings and execute embedded commands or metacharacters. In privileged execution contexts (like Shizuku), this bypasses application boundaries and grants system-level execution.
**Prevention:** Always use array-based execution (`List<String>`) for system processes to pass arguments directly to the executable rather than through a shell parser. For Shizuku's `newProcess`, avoid `sh -c` entirely.
