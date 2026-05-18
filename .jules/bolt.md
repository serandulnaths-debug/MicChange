## 2024-06-25 - Shizuku Reflection Caching
**Learning:** Using reflection on every command execution via Shizuku's `newProcess` API is expensive and causes unnecessary overhead.
**Action:** When using Shizuku's reflection APIs, always cache the reflected methods using a `lazy` property to improve performance.
