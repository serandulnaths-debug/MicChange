## 2024-05-24 - Enhance Switch Touch Target and Accessibility in Jetpack Compose
**Learning:** Using `Modifier.toggleable` on a parent layout (e.g., `Row`) of a `Switch` component with `role = Role.Switch`, and setting the `Switch`'s `onCheckedChange` to `null` significantly improves the touch target area and screen reader semantics without breaking visual styling or individual component states.
**Action:** Apply `Modifier.toggleable` to parent containers of toggleable controls to ensure a larger interactive area and more coherent a11y announcements.
