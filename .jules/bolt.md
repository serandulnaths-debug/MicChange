## 2024-11-20 - [Cache Reflection Methods]
**Learning:** Frequent reflection calls (like `getDeclaredMethod`) inside tight loops or frequently called methods (like `runCommand`) are expensive and create a performance bottleneck in this app's architecture.
**Action:** Always cache `java.lang.reflect.Method` objects using `lazy` or static initialization when they are reused, as they do not hold onto class instances and are safe to cache.
