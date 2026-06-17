## 2024-06-17 - Cache expensive Shizuku reflection lookups
**Learning:** Calling `Shizuku::class.java.getDeclaredMethod` repeatedly on every command execution adds unnecessary reflection overhead. This is a common performance pitfall when using Shizuku's hidden APIs.
**Action:** Use a `lazy` property to cache the reflected `Method` object on first access to avoid redundant reflection lookups.
