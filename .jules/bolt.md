## 2024-06-30 - Cache Java Reflection Lookups
**Learning:** Repetitive Java reflection lookups (like `getDeclaredMethod`) inside frequently called functions (like Shizuku command execution) create unnecessary O(N) overhead.
**Action:** Always cache `Method` objects using a `lazy` property inside singleton `object`s when accessing hidden APIs via reflection in Kotlin.
