## 2024-05-24 - Command Injection via Shizuku
**Vulnerability:** System commands were executed using `sh -c` with string interpolation, exposing a command injection risk.
**Learning:** Using raw concatenated shell strings bypasses argument boundary protections, creating an unsafe pattern even if current usages are internally controlled.
**Prevention:** Pass command arguments as an explicit array of strings to the process executor rather than constructing a single shell string.
