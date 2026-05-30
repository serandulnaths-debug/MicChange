## 2024-05-30 - Fix Command Injection Vulnerability in Shizuku Command Runner
**Vulnerability:** Command injection risk due to usage of `sh -c` shell wrapper when executing Shizuku privileged commands.
**Learning:** `ShizukuCommandRunner` previously executed commands by wrapping them in `sh -c` and passing them to Shizuku's `newProcess` method. This approach allows execution of arbitrary shell commands if user input is somehow embedded in the command string, exposing the app to command injection attacks.
**Prevention:** Always use array-based execution (e.g., `List<String>`) for system commands, passing arguments directly to the process execution API instead of wrapping them in a shell. This prevents shell expansion and command injection.
