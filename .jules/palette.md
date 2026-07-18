## 2024-07-18 - Map System Permission States to Compose Interactive Elements
**Learning:** Discovered that system-level permission failures (like missing Shizuku access) caused silent failures when interacting with UI elements because the elements remained enabled.
**Action:** Explicitly map system permission states to the `enabled` states of interactive UI elements to prevent silent failures, and attach `semantics { contentDescription = "..." }` for screen-reader accessibility in Jetpack Compose.
