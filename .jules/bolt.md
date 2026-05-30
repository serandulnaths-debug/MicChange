## 2026-05-30 - Cache Reflection Method Lookups
**Learning:** In ShizukuCommandRunner, looking up hidden API methods via reflection on every command execution is an unnecessary performance overhead and CPU bottleneck.
**Action:** Use a Kotlin `lazy` property to lookup and cache reflection methods once upon first access, improving performance for subsequent command executions.
