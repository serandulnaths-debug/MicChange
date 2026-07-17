## 2024-07-17 - Map Permissions to Interactive States
**Learning:** In Jetpack Compose applications relying on system-level permissions (like Shizuku), interactive UI elements (like Switches) can fail silently or confusingly if the underlying permissions aren't met. Screen readers also require explicit content descriptions for icon-only or generic interactive components.
**Action:** Always map required system permission states directly to the `enabled` properties of interactive UI components, and append `semantics { contentDescription = "..." }` for robust accessibility.
