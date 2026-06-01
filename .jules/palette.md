## 2024-05-18 - Improve Switch Touch Targets and Semantics
**Learning:** Placing click/toggle listeners directly on a `Switch` in Jetpack Compose often results in a small touch target, which is hard to use and less accessible.
**Action:** Always wrap the `Switch` and its associated text labels in a layout like `Row`, and apply `Modifier.toggleable(role = Role.Switch)` to the parent. Set the `Switch`'s `onCheckedChange` to `null` to avoid duplicate interactions and ensure screen readers announce the element properly.
