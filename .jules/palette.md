## 2024-10-24 - Map System Permissions to UI State and Add Semantics
**Learning:** Silent failures occur when interactive elements are enabled but system permissions (like Shizuku) are missing. In Jetpack Compose, mapping permission states to the `enabled` parameter prevents this, and adding `semantics { contentDescription }` makes these dynamic elements screen-reader accessible.
**Action:** Always link system permission availability to the `enabled` state of related UI components in Compose and attach proper semantics for accessibility.
