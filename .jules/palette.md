## 2024-06-16 - Compose Switch Semantics and Touch Targets
**Learning:** In Jetpack Compose, wrapping a `Switch` and its text labels in a `Row` leaves the labels un-tappable and splits semantics for screen readers, reducing accessibility.
**Action:** Apply `Modifier.toggleable()` with `role = Role.Switch` to the parent layout (e.g., `Row`) and set the internal `Switch`'s `onCheckedChange` to `null` to combine semantics and expand the touch target.
