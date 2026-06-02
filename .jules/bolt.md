## 2024-05-18 - Caching Shizuku Reflection Lookups
**Learning:** Calling `getDeclaredMethod` on `rikka.shizuku.Shizuku` repeatedly causes measurable reflection overhead, particularly since system commands are dispatched frequently for audio routing.
**Action:** Use a Kotlin `by lazy` property to cache reflected `Method` references from Shizuku (e.g., `newProcess`) to ensure the lookup occurs only once per app lifecycle, eliminating redundant reflection costs.
