## 2024-06-25 - Cache Expensive Reflection Calls
**Learning:** Repeated reflection lookups (like `getDeclaredMethod`) in frequently executed code paths (like command runners) add significant CPU overhead.
**Action:** Use a `lazy` delegate or static initializer to cache reflected methods on object initialization.
