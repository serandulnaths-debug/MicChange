## 2026-06-26 - Cache Shizuku Reflection Method
**Learning:** Java reflection method lookups inside frequently called functions (like Shizuku commands) cause unnecessary O(N) repetitive overhead. In Kotlin, these can be safely cached using a `lazy` property inside a singleton `object`.
**Action:** Always extract and cache reflective method lookups into lazy properties when used within singletons to eliminate per-call lookup overhead.
