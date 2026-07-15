## 2026-07-15 - Map System Permissions to UI State
**Learning:** In this application, system-level permissions (like Shizuku availability) aren't naturally reflected in the UI, leading to interactive elements silently failing when toggled without permission.
**Action:** Always map system permission states to the `enabled` attribute of interactive Compose UI elements to prevent silent failures, and attach `semantics { contentDescription = "..." }` to maintain screen-reader accessibility.
