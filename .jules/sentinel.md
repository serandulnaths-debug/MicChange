## 2024-05-18 - Command Injection Vulnerability Fix
**Vulnerability:** Execution of Shizuku `newProcess` commands via string concatenation wrapped in `sh -c` introduces severe command injection risk if arguments like package names contain malicious shell metacharacters.
**Learning:** Bypassing standard shell execution and directly utilizing an array of strings natively constructs the exec call without shell parsing, fundamentally neutralizing command injection vulnerabilities.
**Prevention:** When invoking executable commands or leveraging reflective APIs like `newProcess`, construct processes using arrays (e.g., `List<String>`) instead of naive string concatenation wrapped in shell invocations.
