## 2024-05-24 - Cache reflection lookups for Shizuku commands
**Learning:** Repeatedly looking up hidden API methods via Java reflection (e.g., `getDeclaredMethod`) inside frequently called functions incurs an O(N) lookup overhead, creating an unnecessary performance bottleneck.
**Action:** Cache the `Method` object using a `lazy` property inside a singleton `object` to perform the lookup only once.
