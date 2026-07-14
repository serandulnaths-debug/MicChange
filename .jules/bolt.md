## 2024-07-14 - Cache Shizuku newProcess method reflection
**Learning:** Using Java reflection to access hidden Shizuku APIs (like `newProcess`) inside frequent operations incurs repetitive O(N) lookup overhead.
**Action:** When using Java reflection in Kotlin applications to access hidden APIs, cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive O(N) lookup overhead. `Method` objects do not hold class instance references, so caching them indefinitely is safe and does not cause memory leaks.
