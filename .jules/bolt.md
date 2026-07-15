## 2024-07-15 - Cache Java reflection method lookups
**Learning:** Using Java reflection to access hidden APIs (like Shizuku commands) is computationally expensive, incurring O(N) lookup overhead on each call. Because `Method` objects do not hold onto class instances, they can be safely cached without causing memory leaks.
**Action:** When accessing hidden APIs via Java reflection in a Kotlin singleton object, always cache the `Method` object using a `lazy` property to improve performance.
