## 2024-07-02 - Fix Command Injection in Shizuku Command Runner
**Vulnerability:** ShizukuCommandRunner used `sh -c` with interpolated strings for system commands, exposing a command injection risk.
**Learning:** Constructing raw shell strings with variables and executing them via `sh -c` is a dangerous pattern, even when inputs seem safe, because it sets a vulnerable precedent for future command additions.
**Prevention:** Pass command arguments as an array of strings directly to `Process` execution instead of using string interpolation with `sh -c`.
