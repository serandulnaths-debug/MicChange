
## 2024-05-18 - Disabled states based on system permissions
**Learning:** Interactive elements that require system permissions (like Shizuku) can silently fail if left enabled, confusing users. Furthermore, interactive toggles lacking semantic descriptions are inaccessible to screen readers.
**Action:** Always map system permission states explicitly to the `enabled` properties of UI components and provide `semantics { contentDescription = "..." }` for screen readers in Compose.
