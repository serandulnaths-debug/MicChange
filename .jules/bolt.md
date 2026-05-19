## 2024-05-19 - Cache Reflection Method Lookups
**Learning:** Using reflection to call `Shizuku.newProcess` on every command execution is an expensive operation that can cause a performance bottleneck.
**Action:** When using Shizuku's reflection APIs (or any hidden APIs), cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups and improve performance.
