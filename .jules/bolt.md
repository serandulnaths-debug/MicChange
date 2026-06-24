## 2024-05-24 - Caching Reflection in Kotlin Objects
**Learning:** Using Java reflection to access hidden APIs (like Shizuku commands) incurs an O(N) lookup overhead on every invocation.
**Action:** When using Java reflection in Kotlin applications to access hidden APIs, cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive lookup overhead.
