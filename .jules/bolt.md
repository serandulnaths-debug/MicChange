## 2024-05-24 - Cache Expensive Reflection Lookups
**Learning:** Using `getDeclaredMethod` continuously in commonly accessed runtime code causes a measurable performance penalty in Android applications due to reflection overhead.
**Action:** When using Shizuku's reflection APIs (e.g., `newProcess`), cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups.
