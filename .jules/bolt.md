## 2024-05-24 - Cache Shizuku Method Reflection
**Learning:** The codebase was performing reflection on `Shizuku::class.java.getDeclaredMethod` inside `runCommand` which is called repeatedly. Reflection is expensive (O(N) lookup). Since `ShizukuCommandRunner` is a singleton `object`, this was causing unnecessary overhead.
**Action:** When using Java reflection in Kotlin applications to access hidden APIs (e.g., Shizuku commands), cache the `Method` object using a `lazy` property inside a singleton `object` to prevent repetitive O(N) lookup overhead.
