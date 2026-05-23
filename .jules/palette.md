## 2024-05-18 - Improved Switch Accessibility in Compose
**Learning:** Attaching click logic to a `Switch` in Jetpack Compose ignores the surrounding label context. This forces users to tap the small switch directly and screen readers treat the label and switch as separate unrelated elements.
**Action:** Always apply `Modifier.toggleable()` with `role = Role.Switch` to the parent container (like `Row`) instead, and set the `Switch` component's `onCheckedChange` to `null`.
