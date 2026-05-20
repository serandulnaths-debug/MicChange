## 2024-06-25 - Expensive Reflection in Frequently Called Methods
**Learning:** Performing reflection method lookups (e.g., `getDeclaredMethod`) inside a method called repeatedly (like running shell commands) can cause a noticeable performance overhead and slow down the app.
**Action:** Use a `lazy` property or initialize the method reference once statically to cache the reflected method and avoid repeated expensive lookups.
