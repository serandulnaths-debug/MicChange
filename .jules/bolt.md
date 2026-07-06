## 2024-05-25 - Cache Reflection Lookups in Singletons
**Learning:** Using Java reflection (like `getDeclaredMethod`) inside a frequently called function in a Kotlin `object` introduces unnecessary O(N) lookup overhead on every invocation.
**Action:** Always cache reflection objects (`Method`, `Field`, etc.) using a `lazy` property inside the singleton `object` when they are accessed repeatedly.
