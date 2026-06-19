## 2024-06-19 - Improve Jetpack Compose Switch touch target size and semantics
**Learning:** When using Jetpack Compose's `Switch` alongside label texts in a `Row`, the default touch target is restricted to the switch itself, and screen readers read them separately.
**Action:** Apply `Modifier.toggleable(value = isChecked, onValueChange = { ... }, role = Role.Switch)` to the parent `Row` and set the internal `Switch`'s `onCheckedChange` to `null`. This expands the touch area to the entire row and groups the semantics for screen readers.
