## 2024-05-18 - Avoid Reflection Lookup in Hot Paths
**Learning:** Using Java reflection to access hidden APIs (like Shizuku commands) introduces O(N) lookup overhead when called repeatedly inside object methods.
**Action:** Cache the `Method` object using a `lazy` property inside the singleton `object` to prevent repetitive reflection overhead.
