## 2024-07-10 - Cache Shizuku Method Reflection
**Learning:** Repetitively looking up Java methods via reflection (e.g., Shizuku.newProcess) in frequently called methods adds unnecessary O(N) lookup overhead.
**Action:** Always cache the `Method` object using a `lazy` property inside a singleton `object` when using Java reflection to access hidden APIs in Kotlin.
