## 2024-05-24 - Cache Shizuku reflection methods
**Learning:** Using Shizuku's hidden APIs via reflection (like `newProcess`) on every command execution is an unnecessary performance bottleneck. Repeated reflection lookups are expensive.
**Action:** Always cache the reflected `Method` using a `lazy` property to ensure thread-safe, one-time initialization, reducing overhead on subsequent calls.
