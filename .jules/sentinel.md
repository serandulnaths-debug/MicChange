## 2024-05-24 - Command Injection via Shizuku `sh -c`
**Vulnerability:** Execution of Shizuku commands through `sh -c` with concatenated strings allowed for shell command injection.
**Learning:** Using shell wrappers like `sh -c` natively introduces shell parsing. Passing user-controlled or dynamically constructed strings without rigorous sanitization can be trivially escaped.
**Prevention:** Always use array-based execution mechanisms (`List<String>`) passing the executable and arguments separately. This avoids the shell entirely, directly launching the process and eliminating shell parsing injection vulnerabilities. When using Shizuku's `newProcess`, provide arguments as `Array<String>` instead of formatting them into a single string.
