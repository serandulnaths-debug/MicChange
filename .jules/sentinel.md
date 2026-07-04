## 2024-05-24 - Fix Command Injection Vulnerability in Shizuku Command Runner
**Vulnerability:** Command injection risk via interpolated shell commands (`sh -c <cmd>`) when running Shizuku processes.
**Learning:** Shizuku commands run with elevated privileges (ADB or root), and directly substituting user-controlled strings (like package names or variables) into `sh -c` introduces a critical command injection vector.
**Prevention:** Pass process arguments as an explicit array of strings to `Shizuku.newProcess` instead of concatenating them into a raw shell string, effectively mitigating injection through safe argument tokenization.
