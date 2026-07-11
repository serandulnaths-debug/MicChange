## 2024-05-24 - Cache Java Reflection Methods in Kotlin Singletons
**Learning:** Using Java reflection to access hidden APIs (like Shizuku's `newProcess`) inside a frequently called function (like `runCommand`) introduces repetitive O(N) method lookup overhead every time it is invoked.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` so the reflection lookup and accessibility modification only happens once.
