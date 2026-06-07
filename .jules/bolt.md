## 2024-05-18 - Cache Shizuku reflection
**Learning:** Using reflection for Shizuku's newProcess API is a bottleneck when invoking multiple commands.
**Action:** Cache the reflected method using a lazy property to improve performance.
