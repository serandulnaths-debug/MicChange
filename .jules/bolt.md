## 2026-08-02 - Cache Shizuku reflection lookups
**Learning:** The ShizukuCommandRunner executes shell commands by looking up the hidden 'newProcess' API via reflection on every invocation. In an app that may rapidly toggle audio routing commands, this repeated reflection lookup creates a localized CPU bottleneck specific to this app's Shizuku integration architecture.
**Action:** Use Kotlin's 'lazy' property delegate within the singleton object to cache the java.lang.reflect.Method instance indefinitely, eliminating reflection overhead on subsequent calls without risking memory leaks.
