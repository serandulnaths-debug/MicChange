## 2024-05-24 - Shizuku Reflection Bottleneck
**Learning:** Repeatedly querying hidden APIs via reflection (like Shizuku's `newProcess`) on every command execution causes unnecessary overhead, which is especially noticeable since routing commands block the calling thread.
**Action:** Cache `Method` references indefinitely using `lazy` delegates in singletons, which is safe from memory leaks as `Method` objects don't hold instance references.
