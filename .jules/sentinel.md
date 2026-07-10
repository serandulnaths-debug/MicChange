## 2024-05-30 - Fix Shizuku Command Injection
**Vulnerability:** Constructing raw shell commands via `sh -c` with string interpolation in Shizuku's `newProcess` API.
**Learning:** Interpolated variables like `packageName` can theoretically be exploited to inject arbitrary shell commands if the input isn't properly sanitized. Passing strings to `sh -c` bypasses argument boundary protections.
**Prevention:** Always pass command arguments directly as an `Array<String>` to `newProcess` (e.g. `arrayOf("appops", "set", ...)`), allowing the system to handle argument boundaries safely rather than a shell evaluating them.
