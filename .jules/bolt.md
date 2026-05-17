## 2024-12-16 - Cache Reflection Lookups for Shizuku
**Learning:** Using reflection to invoke Shizuku API functions (`Shizuku.newProcess`) within a frequently called method introduces unnecessary performance overhead.
**Action:** Use a `lazy` property to cache the resolved reflection `Method` on startup or first use to avoid repeated expensive lookups.
