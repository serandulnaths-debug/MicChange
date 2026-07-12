## 2024-05-30 - Caching Java reflection lookups
**Learning:** Using Java reflection to access hidden APIs (like Shizuku commands) incurs repetitive O(N) lookup overhead if performed on every method call.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to perform the lookup only once.
