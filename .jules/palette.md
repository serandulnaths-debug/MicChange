## 2024-05-24 - Improve Switch Touch Target and Accessibility
**Learning:** Applying Modifier.toggleable() to the parent Row of a Switch and setting the Switch's onCheckedChange to null significantly improves touch targets and screen reader semantics in Jetpack Compose.
**Action:** Always apply toggleable to the parent container with Role.Switch for switch toggles instead of placing the interaction solely on the switch component.
