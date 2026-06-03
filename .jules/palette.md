## 2024-05-24 - Improve Switch touch target and a11y
**Learning:** In Jetpack Compose, the default touch target for a standalone `Switch` only covers the switch itself, which can be small and harder to tap.
**Action:** When a `Switch` has adjacent text labels, apply `Modifier.toggleable()` with `role = Role.Switch` to their parent layout (like a `Row`) and set the internal `Switch`'s `onCheckedChange` to `null`. This expands the clickable area to include the labels and improves screen reader semantics.
