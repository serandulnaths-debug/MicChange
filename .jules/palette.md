## 2024-07-07 - Map System Permissions to UI State and Screen Readers
**Learning:** In Jetpack Compose, interactive elements relying on system-level permissions (like Shizuku) can silently fail if their `enabled` state isn't explicitly mapped to those permissions, and screen readers need `semantics { contentDescription = "..." }` attached for context.
**Action:** Always map system permission availability to the `enabled` state of related UI components and attach `semantics` for accessibility to prevent silent failures and improve screen-reader support.
