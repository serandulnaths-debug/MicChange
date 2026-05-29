## 2026-05-29 - Switch Accessibility in Compose
**Learning:** In Jetpack Compose, an isolated Switch has a small touch target and lacks context for screen readers if it isn't semantically grouped with its labels.
**Action:** Apply `Modifier.toggleable(value = state, role = Role.Switch, onValueChange = { ... })` to the parent `Row` (or layout) containing the `Switch` and text labels, and set the internal `Switch`'s `onCheckedChange` to `null`. This drastically improves touch target size and semantic grouping.
