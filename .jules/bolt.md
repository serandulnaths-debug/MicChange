## 2024-05-19 - Shizuku Reflection Overhead
**Learning:** Using `Class.forName` or `getDeclaredMethod` on every Shizuku command execution causes unnecessary performance overhead since Shizuku's `newProcess` method signature does not change.
**Action:** Use Kotlin's `lazy` delegate to cache expensive reflection method lookups when wrapping system APIs to improve execution speed.
