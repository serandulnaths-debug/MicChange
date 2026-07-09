## 2024-05-24 - Cache Shizuku newProcess method reflection
**Learning:** Using Java reflection to access hidden APIs (like Shizuku's `newProcess`) inside frequently called functions incurs an O(N) lookup overhead on every execution.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to perform the lookup only once.
