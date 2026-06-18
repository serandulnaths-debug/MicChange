## 2024-05-24 - Improve Switch Accessibility
**Learning:** In Jetpack Compose, the default Switch component has a small touch target. By applying Modifier.toggleable() to its parent layout (e.g., Row) with role = Role.Switch, and setting the Switch's onCheckedChange to null, we dramatically improve both the touch target size for standard interaction and semantic grouping for screen readers.
**Action:** Always apply toggleable modifier to the parent layout of a Switch when it is accompanied by text labels, rather than putting the interaction solely on the Switch.
