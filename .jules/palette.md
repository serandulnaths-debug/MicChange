## 2024-06-08 - Improved Switch Accessibility and Touch Targets
**Learning:** In Jetpack Compose, clicking text labels next to a Switch doesn't automatically toggle the Switch like in traditional web or Android UI. This leads to poor touch targets and screen reader experience.
**Action:** Apply `Modifier.toggleable()` (with `role = Role.Switch`) to the parent layout (e.g., `Row`) of the `Switch` and its text label, and set the internal `Switch`'s `onCheckedChange` to `null`.
