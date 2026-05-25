## 2024-11-20 - Cache expensive reflection lookups
**Learning:** Calling `Class.getDeclaredMethod` via reflection is a relatively slow operation in Kotlin/Java. It should not be done repeatedly inside frequently called functions (like command execution wrappers).
**Action:** Always cache the `java.lang.reflect.Method` instance using `lazy { ... }` or another caching mechanism to improve performance, especially when making IPC/system calls.
