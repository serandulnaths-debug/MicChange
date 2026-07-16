## 2024-05-24 - Caching Java Reflection Methods
**Learning:** Repeatedly looking up Java reflection methods via `getDeclaredMethod` inside a frequently called function introduces unnecessary O(N) lookup overhead.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive O(N) lookup overhead.
