## 2024-10-24 - Cache Shizuku reflection lookups
**Learning:** Using `getDeclaredMethod` repeatedly via reflection in high-frequency methods like `ShizukuCommandRunner.runCommand` introduces unnecessary performance overhead due to repeated lookups.
**Action:** When using Shizuku's reflection APIs (e.g., `newProcess`), cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups and improve performance.
