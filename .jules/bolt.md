## 2024-05-24 - Cache Shizuku Reflection
**Learning:** Repeatedly looking up Shizuku's hidden API methods (like `newProcess`) via reflection inside `runCommand` creates a performance bottleneck since reflection is an expensive operation in Android.
**Action:** Cache the reflected methods using a `lazy` property to ensure the lookup and accessibility modification happen only once, improving subsequent command execution times.
