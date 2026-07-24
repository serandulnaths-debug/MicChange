## 2024-05-18 - Caching Reflection Method Lookup
**Learning:** Repetitive reflection method lookups on hot paths (like running shell commands) can cause unnecessary CPU overhead and garbage collection. Shizuku's hidden `newProcess` method was being reflected every time a command was run.
**Action:** Always cache `java.lang.reflect.Method` lookups in singleton objects or via `lazy` delegates when they will be called repeatedly, as the `Method` object itself does not leak class instance memory.
