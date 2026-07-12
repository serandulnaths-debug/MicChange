## 2024-07-12 - Map System Permissions to UI State and Add Semantics
**Learning:** Silent failures in Jetpack Compose elements can be confusing for users when interacting without required permissions (like Shizuku).
**Action:** Explicitly map system permission states (e.g., `isShizukuAvailable && hasShizukuPermission`) to the `enabled` properties of interactive UI components, and always attach `semantics { contentDescription = "..." }` for screen-reader accessibility to ensure an inclusive experience.
