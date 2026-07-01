## 2024-07-01 - Fix Shizuku command injection vulnerability
**Vulnerability:** System commands executed via Shizuku used `sh -c` with interpolated strings, creating a command injection risk.
**Learning:** Bypassing `sh -c` and passing arguments as an array directly to `Shizuku.newProcess` mitigates command injection without losing functionality.
**Prevention:** Always use `Array<String>` for command execution arguments instead of raw string construction with `sh -c`.
