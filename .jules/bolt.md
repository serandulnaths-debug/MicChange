## 2024-06-10 - Cache Shizuku Reflection
**Learning:** The `newProcess` method lookup on `Shizuku` via reflection is an expensive operation if done on every command execution.
**Action:** Cache the reflected methods using a `lazy` property to avoid repeated expensive reflection lookups and improve performance when executing multiple commands.
