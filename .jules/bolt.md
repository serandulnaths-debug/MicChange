## 2024-05-18 - Cache Shizuku Reflection
**Learning:** Reflection lookups like `getDeclaredMethod` are expensive and should not be invoked repeatedly on hot paths.
**Action:** Use a `lazy` property to cache reflected methods when calling hidden APIs like Shizuku's `newProcess`.
