## 2026-06-04 - Cache expensive reflection lookups
**Learning:** Using `getDeclaredMethod` and `isAccessible = true` repeatedly inside a method that executes frequently (like `runCommand`) introduces unnecessary overhead. In Kotlin, `by lazy` is an effective way to cache this reflection lookup efficiently while ensuring it is only initialized once when first accessed.
**Action:** When using reflection to access hidden APIs (like Shizuku's `newProcess`), cache the `Method` instance using a `lazy` property delegate on the enclosing object/class.
