## 2024-05-24 - Cache reflection lookups for system APIs
**Learning:** Repeatedly reflecting system-level methods in hot paths like command runners introduces unnecessary overhead.
**Action:** Cache reflected methods using a `lazy` property in Kotlin objects to ensure they are looked up only once and reused.
