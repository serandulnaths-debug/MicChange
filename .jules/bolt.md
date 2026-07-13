## 2024-07-13 - Cache Reflection Methods in Kotlin
**Learning:** Repetitive Java reflection (e.g., `getDeclaredMethod`) inside frequently called functions introduces unnecessary O(N) lookup overhead. Caching the `Method` object indefinitely is safe and does not cause memory leaks as it does not hold onto class instances.
**Action:** Always cache reflected `Method` objects using a `lazy` property inside a singleton `object` to perform the lookup only once.
