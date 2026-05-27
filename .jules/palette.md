
## 2024-05-27 - Improve touch targets and semantics for Switches
**Learning:** Applying `Modifier.toggleable()` to the parent layout (like a `Row`) of a `Switch` and its text label, while setting the internal `Switch`'s `onCheckedChange` to `null`, significantly improves accessibility by creating a larger touch target and providing correct semantics for screen readers.
**Action:** Always use `Modifier.toggleable()` (with `role = Role.Switch`) on the parent container when building custom toggle rows instead of relying on the Switch component's default touch target.
