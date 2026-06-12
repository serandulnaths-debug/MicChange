## 2026-06-12 - Cache Reflection Lookups
**Learning:** Reflection method lookups (like `Class.getDeclaredMethod`) are expensive and can be a bottleneck if called repeatedly, such as inside `ShizukuCommandRunner.runCommand` which might be called frequently for audio routing updates.
**Action:** Cache the reflected methods using a `lazy` property or initialization block to evaluate them only once.
