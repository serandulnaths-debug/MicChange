## 2024-07-04 - Map System Permission States to Interactive UI Controls
**Learning:** Interactive elements in Jetpack Compose that depend on system-level permissions (like Shizuku) can cause silent failures and confusion if their `enabled` states aren't explicitly mapped to those permission states. Additionally, custom switches need `semantics` for screen readers.
**Action:** Always map system permission states to the `enabled` properties of relevant UI controls and provide explicit `contentDescription` via `semantics` for screen-reader accessibility in Jetpack Compose applications.
