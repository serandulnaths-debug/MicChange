## 2024-05-15 - [Initial Sentinel setup]
**Vulnerability:** Initial setup
**Learning:** Nothing yet
**Prevention:** Nothing yet
## 2024-05-15 - [Prevent Command Injection in Shizuku Command Runner]
**Vulnerability:** Command injection vulnerability in `ShizukuCommandRunner.runCommand(command: String)`. By using `sh -c` with string concatenation (e.g. `arrayOf("sh", "-c", command)`), arbitrary command execution is possible if the `command` string contains user-supplied data or untrusted inputs.
**Learning:** System permissions tools often introduce severe injection risks when wrapping commands in a shell environment (`sh -c`) instead of passing arguments as an array to `exec` / `newProcess`.
**Prevention:** Change the signature of `runCommand` to accept `vararg command: String`, avoiding string concatenation and skipping the `sh -c` wrapper. Ensure `newProcess` receives the exact command and arguments via `arrayOf(*command)`.
