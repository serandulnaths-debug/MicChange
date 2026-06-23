## 2024-06-23 - Caching reflection Method objects
**Learning:** Repetitive use of `Class.getDeclaredMethod()` inside frequently called methods (like command execution) introduces O(N) lookup overhead.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` when using Java reflection in Kotlin applications to prevent performance bottlenecks.
