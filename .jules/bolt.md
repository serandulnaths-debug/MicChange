## 2024-05-24 - Java Reflection Caching for Shizuku Commands
**Learning:** In Kotlin applications, repeatedly accessing hidden APIs (like Shizuku commands) via Java reflection causes repetitive O(N) lookup overhead which degrades performance on every system command executed.
**Action:** Always cache the `Method` object using a `lazy` property inside a singleton `object` to perform the lookup only once.
