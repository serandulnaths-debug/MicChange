## 2024-05-24 - Improve Switch Accessibility with Toggleable Role
**Learning:** By applying `Modifier.toggleable()` with `role = Role.Switch` to the parent layout of a Switch component, the touch target area is expanded and screen reader semantics are improved. Setting `onCheckedChange` to `null` on the Switch itself is crucial to prevent conflicting touch events.
**Action:** Always apply `toggleable` to the parent container when a Switch is accompanied by labels to ensure a robust and accessible user experience.
