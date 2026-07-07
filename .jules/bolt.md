## 2026-07-07 - Cache Java Reflection Method for Shizuku
**Learning:** Java reflection method lookups (like `getDeclaredMethod`) have O(N) overhead and can cause performance bottlenecks when called repeatedly in hot paths.
**Action:** Always cache `Method` objects using a `lazy` property inside a singleton `object` when using reflection in Kotlin applications to access hidden APIs like Shizuku commands.
