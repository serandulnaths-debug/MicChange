## 2024-05-18 - Prevent Command Injection via Shizuku reflection API
**Vulnerability:** Execution of system commands using `sh -c` wrapper combined with string concatenation is susceptible to command injection, as arbitrary user/app input might get evaluated by the shell.
**Learning:** Using `sh -c` inside `Shizuku.newProcess` is dangerous. Additionally, constantly reflecting `Shizuku.newProcess` creates unnecessary overhead, and using string splitting instead of exact list execution introduces parsing errors on complex arguments.
**Prevention:** Always pass commands as a `List<String>` directly to the underlying `newProcess` API, avoiding shell wrappers altogether. Cache the reflection method lookup via `lazy` to improve performance without degrading security.
