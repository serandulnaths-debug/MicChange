## 2024-07-20 - Map Permissions to Interactive States
**Learning:** Explicitly mapping system permission states (e.g., Shizuku availability) to the `enabled` states of interactive UI elements prevents silent failures, and adding semantics is critical for screen reader accessibility.
**Action:** Always verify if a UI component's action depends on a system permission and bind that permission state to the component's `enabled` property, while also ensuring `contentDescription` semantics are attached for accessibility.
