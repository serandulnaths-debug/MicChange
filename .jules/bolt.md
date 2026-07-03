## 2024-07-03 - Caching Reflection Method Lookups
**Learning:** Repetitive Java reflection lookups (`getDeclaredMethod`) in Kotlin applications cause unnecessary O(N) overhead when used to access hidden APIs like Shizuku commands.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive lookup overhead.
