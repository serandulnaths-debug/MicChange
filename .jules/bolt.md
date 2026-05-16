## 2024-05-16 - Shizuku Main Thread Blocking
**Learning:** `process.waitFor()` from Shizuku's `newProcess` reflection API blocks the thread it runs on. When called directly from UI logic, it causes main thread hitches. Additionally, reflecting `getDeclaredMethod` on every invocation adds unnecessary overhead.
**Action:** Always wrap blocking Shizuku calls in `withContext(Dispatchers.IO)` and use `suspend fun`. Cache reflection methods in a lazy `val`. Furthermore, use `List<String>` for the command arguments to avoid the overhead and injection risks of spawning a `sh -c` shell.
