## 2026-06-22 - Cache Java reflection for Shizuku hidden APIs
**Learning:** Using Java reflection to access hidden APIs (like Shizuku commands) inside frequently called methods causes repetitive O(N) lookup overhead.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to prevent overhead on subsequent calls.
