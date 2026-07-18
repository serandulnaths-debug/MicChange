## 2024-05-18 - Caching Reflection Lookups in Kotlin
**Learning:** Repetitive reflection lookups for `Shizuku.newProcess` inside a frequently called function (`ShizukuCommandRunner.runCommand`) causes unnecessary O(N) overhead.
**Action:** Use a `lazy` property inside a singleton `object` to cache the `Method` object and avoid repeated lookups.
