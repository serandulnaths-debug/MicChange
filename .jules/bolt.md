## 2024-05-19 - Cache Reflection for Performance
**Learning:** Using `getDeclaredMethod` on every execution can be a significant performance bottleneck in an app that runs repeated system commands.
**Action:** Use `lazy` delegates to cache the reflected method properties, avoiding expensive redundant reflection lookups.
