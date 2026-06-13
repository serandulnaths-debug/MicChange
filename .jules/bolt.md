## 2024-05-24 - Cache Expensive Reflection Calls
**Learning:** Repeated reflection calls for hidden APIs, like `Shizuku.newProcess`, create unnecessary CPU overhead, especially when invoked frequently.
**Action:** Cache the `Method` object lookup using Kotlin's `lazy` delegate so the reflection overhead is incurred only once.
