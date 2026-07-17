## 2024-07-17 - Shizuku reflection caching
**Learning:** Calling Shizuku's hidden newProcess API via reflection on every command execution causes unnecessary overhead due to method lookup.
**Action:** Cache the java.lang.reflect.Method object using a lazy property in a singleton to avoid O(N) reflection lookup costs on repeated calls.
