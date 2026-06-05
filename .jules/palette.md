## 2024-11-20 - Improve Switch Component Touch Targets and Semantics
**Learning:** In Jetpack Compose, a standalone `Switch` next to a `Text` label creates small touch targets and disjointed screen reader announcements.
**Action:** Always apply `Modifier.toggleable(role = Role.Switch)` to the parent `Row` of the `Switch` and its labels, moving the toggle state logic there and setting the internal `Switch`'s `onCheckedChange` to `null`. This enlarges the interactive area and provides proper unified semantics for accessibility services.
