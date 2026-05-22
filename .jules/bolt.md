## 2024-05-24 - Shizuku Reflection Overhead

**Learning:** Repeatedly using reflection to access hidden Shizuku APIs (like `newProcess`) introduces a performance bottleneck, as reflection lookups and accessibility modifications are expensive.
**Action:** Cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups and improve performance when repeatedly calling Shizuku APIs.
