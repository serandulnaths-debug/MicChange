## 2024-05-24 - Cache Reflection for System APIs
**Learning:** Repeated reflection lookups for hidden system APIs (like Shizuku's `newProcess`) can become performance bottlenecks.
**Action:** Use a `lazy` property to cache the reflected method on first access to prevent expensive repeated lookups and improve command execution latency.
