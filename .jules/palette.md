## 2024-07-05 - Map System Permission States to Interactive Elements and Add Content Description
**Learning:** In Jetpack Compose, failing to explicitly map system permission states (e.g., Shizuku availability) to the `enabled` states of interactive UI elements can cause silent failures and confuse users. Interactive elements also require `semantics { contentDescription = "..." }` for screen-reader accessibility.
**Action:** Always map backend or system-level permission states directly to the `enabled` property of Compose controls and attach semantic content descriptions for screen readers.
