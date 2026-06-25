## 2026-06-25 - Cache reflection method lookups
**Learning:** Repetitive O(N) lookup overhead occurs when using Java reflection repeatedly inside frequently invoked functions like command runners.
**Action:** When using Java reflection in Kotlin applications to access hidden APIs (e.g., Shizuku commands), cache the `Method` object using a `lazy` property inside a singleton `object`.
