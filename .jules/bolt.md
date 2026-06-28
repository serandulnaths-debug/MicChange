## 2024-06-28 - Cache Reflection Method for Shizuku
**Learning:** Using Java reflection in Kotlin applications to access hidden APIs inside frequently called functions introduces repetitive O(N) lookup overhead.
**Action:** When using Java reflection to access hidden APIs, cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive lookup overhead.
