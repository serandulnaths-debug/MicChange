## 2026-05-31 - Cache Shizuku Reflection
**Learning:** When using Shizuku's reflection APIs (e.g., `newProcess`), repeated reflection lookups (like `getDeclaredMethod`) inside tight loops or frequently called functions can add unnecessary overhead.
**Action:** When using Shizuku's reflection APIs, cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups and improve performance.
