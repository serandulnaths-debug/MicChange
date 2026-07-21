## 2024-07-21 - Cache Reflection Lookups in Singletons
**Learning:** Frequent reflection lookups (like `getDeclaredMethod`) inside frequently called utility methods add unnecessary overhead. Because `java.lang.reflect.Method` objects do not hold onto class instances, caching them indefinitely in a singleton is safe and does not cause memory leaks.
**Action:** Use Kotlin's `by lazy` delegate to cache `Method` lookups in singleton objects, avoiding repetitive reflection overhead on subsequent calls.
