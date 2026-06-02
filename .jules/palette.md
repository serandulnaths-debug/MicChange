## 2024-05-23 - Improve touch targets for Switch components
**Learning:** Adding toggleable modifier to the parent layout of a Switch improves touch targets and screen reader semantics.
**Action:** Apply `Modifier.toggleable` (with `role = Role.Switch`) to the parent layout of a `Switch` and its text label, and set the internal `Switch`'s `onCheckedChange` to `null`.
