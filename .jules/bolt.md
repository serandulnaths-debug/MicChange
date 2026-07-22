## 2024-05-24 - Cache Shizuku Method Reflection
**Learning:** Caching `java.lang.reflect.Method` objects indefinitely (e.g., using a `lazy` property inside a singleton) is safe and does not cause memory leaks, as `Method` objects do not hold onto class instances.
**Action:** Cache the Shizuku `newProcess` method using `lazy` property to avoid the overhead of reflection lookups on every command execution.
