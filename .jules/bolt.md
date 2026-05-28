## 2024-05-24 - Cache Expensive Shizuku Reflection
**Learning:** Using Shizuku's hidden APIs (like `newProcess`) requires reflection lookups. Doing this inside frequently called methods causes unnecessary CPU overhead.
**Action:** Always cache the reflected methods using a `lazy` property or during initialization to avoid repeated expensive reflection lookups.