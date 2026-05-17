## 2026-05-17 - Jetpack Compose Switch Accessibility and UX
**Learning:** In Jetpack Compose, wrapping a `Switch` and its accompanying text labels in a `Row` does not automatically group them semantically or increase the touch target size for the switch action.
**Action:** Always apply `Modifier.toggleable(value = ..., onValueChange = ..., role = Role.Switch)` to the parent layout (e.g., `Row`) and set the inner `Switch`'s `onCheckedChange` to `null`. This creates a large, semantically correct touch target for both touch interaction and screen readers.
