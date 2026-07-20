## 2024-07-20 - Cache Reflection Lookup
**Learning:** Repetitive use of `Class.getDeclaredMethod` inside frequently called functions (like command runners) introduces O(N) lookup overhead on the reflection API, impacting execution speed.
**Action:** Always cache Java Reflection `Method` objects using a `lazy` property inside a singleton `object` to perform the lookup only once.
