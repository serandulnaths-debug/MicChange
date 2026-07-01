## 2024-07-01 - Disabled states for system permission dependent actions
**Learning:** System-level permission states (like Shizuku availability) should be explicitly mapped to the `enabled` state of interactive UI elements in Jetpack Compose, preventing silent action failures. Adding semantics for screen readers ensures the context is accessible.
**Action:** Always evaluate external dependencies or permissions and disable related UI elements (like Switches or Buttons) when preconditions aren't met, while adding proper `semantics { contentDescription = "..." }` for accessibility.
