## 2024-07-04 - Cache Shizuku Reflection Methods
**Learning:** Using Java reflection (`getDeclaredMethod`) for hidden APIs inside a frequently called function (`runCommand`) introduces repetitive O(N) lookup overhead.
**Action:** Cache the `Method` object using a `lazy` property inside the singleton `object` to perform the lookup only once.
