## 2026-06-08 - Cache Reflection for Shizuku newProcess
**Learning:** When using Shizuku's reflection APIs (e.g., `newProcess`), repeatedly looking up the method with `getDeclaredMethod` introduces unnecessary overhead. This is especially true for utility methods like `runCommand` that might be called frequently.
**Action:** Always cache reflected methods using a `lazy` property in Kotlin to avoid repeated expensive reflection lookups and improve performance.
