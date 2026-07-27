## 2024-07-27 - Cache reflection methods for performance
**Learning:** Reflection lookup via `getDeclaredMethod` is an expensive operation that can cause performance overhead when called frequently (e.g., executing system commands). Caching `java.lang.reflect.Method` objects indefinitely (e.g., using a `lazy` property inside a singleton) is safe and does not cause memory leaks, as `Method` objects do not hold onto class instances.
**Action:** Cache the result of `getDeclaredMethod` using a `lazy` property in Kotlin objects/singletons instead of re-evaluating it on every method call.
