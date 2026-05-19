## 2024-05-24 - Accessible Switch Layouts in Jetpack Compose
**Learning:** Switch components often have small touch targets when placed next to labels. Wrapping them in a Row with Modifier.toggleable(role = Role.Switch) and setting the Switch's onCheckedChange to null improves both the touch target area and screen reader semantics.
**Action:** Always apply Modifier.toggleable to the parent container when a Switch has visible text labels alongside it, rather than placing the click handler solely on the Switch.
