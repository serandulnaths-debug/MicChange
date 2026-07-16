## 2024-07-16 - Map system permissions to interactive UI state
**Learning:** In Compose, interactive elements relying on system permissions (like Shizuku) can silently fail if left enabled while lacking permissions. Users might click a switch that does nothing. Additionally, screen readers need explicit `contentDescription` on interactive elements like `Switch` to convey their purpose.
**Action:** Always map system permission states explicitly to the `enabled` states of interactive UI elements and attach `semantics { contentDescription = "..." }` for accessibility.
