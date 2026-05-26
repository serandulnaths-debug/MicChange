## 2026-05-26 - Cache Shizuku Reflection
**Learning:** Using reflection to call Shizuku's hidden `newProcess` API is expensive. Doing this lookup on every command execution introduces unnecessary latency.
**Action:** When using Shizuku's reflection APIs (e.g., `newProcess`), cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups and improve performance.
