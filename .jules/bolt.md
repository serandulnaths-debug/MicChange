## 2026-06-16 - Cache Shizuku reflection lookups
**Learning:** Repeated reflection calls for Shizuku APIs (like `newProcess`) on every command execution create unnecessary overhead.
**Action:** Cache the reflected methods using a `lazy` property to improve performance and avoid repeated expensive reflection lookups.
