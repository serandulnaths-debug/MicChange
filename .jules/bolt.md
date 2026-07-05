## 2024-05-24 - Shizuku Reflection Caching
**Learning:** Java reflection (`getDeclaredMethod`) is an O(N) operation and can cause performance overhead when repeatedly called inside frequent operations like `ShizukuCommandRunner.runCommand`.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive O(N) lookup overhead.
