## 2024-06-17 - Improve Switch semantics and touch target in Jetpack Compose
**Learning:** In Jetpack Compose, clicking a `Switch`'s label does not automatically toggle the switch, reducing touch targets and confusing screen readers if not grouped correctly.
**Action:** Apply `Modifier.toggleable()` with `role = Role.Switch` to the parent `Row` of the `Switch` and its label, and set the internal `Switch`'s `onCheckedChange` to `null`.
