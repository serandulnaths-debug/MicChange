## 2026-07-02 - Cache reflection objects
**Learning:** When using Java reflection in Kotlin applications to access hidden APIs (e.g., Shizuku commands), repeating the lookup causes O(N) overhead per call.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive O(N) lookup overhead.
