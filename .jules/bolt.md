## 2024-06-25 - [Optimize Shizuku Command Execution]
**Learning:** Performing reflection (`getDeclaredMethod`) on every execution when calling hidden Shizuku APIs like `newProcess` adds unnecessary overhead.
**Action:** Cache the reflected method using Kotlin's `lazy` delegate so the expensive reflection lookup only occurs once per application lifecycle.
