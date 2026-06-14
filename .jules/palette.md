## 2024-05-24 - Compose Switch Accessibility and Touch Targets
**Learning:** In Jetpack Compose, applying state updates directly to a `Switch` leaves its label non-interactive, reducing the touch target size and hurting accessibility. Screen readers also treat the label and switch as separate entities.
**Action:** Apply `Modifier.toggleable(role = Role.Switch)` to the parent `Row` containing the `Switch` and its label, handle the state change there, and set the internal `Switch`'s `onCheckedChange` to `null`.
