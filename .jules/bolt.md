## 2024-06-11 - Shizuku Reflection Caching
**Learning:** Reflection lookups inside frequently called command runners create unnecessary overhead.
**Action:** Cache reflected methods using a `lazy` property to avoid repeated expensive lookups.
