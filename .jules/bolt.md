## 2024-06-21 - Cache Reflection Methods in Frequent Calls
**Learning:** Reflection operations (like `getDeclaredMethod`) inside frequently called utility functions are expensive and cause O(N) lookup overhead.
**Action:** Always cache these method lookups using `lazy` initialization in a singleton or object to ensure the reflection cost is only paid once.
