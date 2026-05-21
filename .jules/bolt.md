## 2024-05-24 - Shizuku Reflection Caching
**Learning:** In ShizukuCommandRunner.kt, repeated calls to Shizuku::class.java.getDeclaredMethod caused expensive reflection lookups on every command execution.
**Action:** When using Shizuku's reflection APIs (e.g., newProcess), cache the reflected methods using a lazy property to avoid repeated expensive reflection lookups and improve performance.
