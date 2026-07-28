## 2024-05-24 - Reflection Caching in ShizukuCommandRunner
**Learning:** Caching `java.lang.reflect.Method` objects indefinitely (using a `lazy` property inside a singleton) is safe and does not cause memory leaks, as `Method` objects do not hold onto class instances.
**Action:** Extract and cache reflection lookups (`getDeclaredMethod`) into lazy properties when used in frequently called functions to avoid repeated expensive reflection operations.
