## 2024-06-18 - Cache expensive reflection lookups
**Learning:** Repeated reflection lookups (like `getDeclaredMethod`) inside frequently called functions (e.g. `runCommand`) create significant overhead and unnecessary allocations.
**Action:** Always cache reflection `Method` objects in a `lazy` property or singleton to perform the lookup only once.
