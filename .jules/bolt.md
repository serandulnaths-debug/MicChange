## 2024-05-24 - Shizuku Hidden API Reflection Caching
**Learning:** Shizuku commands often rely on hidden APIs via reflection (like `newProcess`). Since they are frequently executed (e.g. `appops` checks), repeatedly resolving them using `getDeclaredMethod` introduces significant performance overhead.
**Action:** Cache the reflected `Method` objects using a `lazy` property in singletons to resolve them once and speed up subsequent system-level calls.
