## 2026-06-09 - Improve Switch Touch Target
**Learning:** In Jetpack Compose, applying Modifier.toggleable() to a Switch's parent Row and setting the Switch's onCheckedChange to null significantly improves touch targets and screen reader semantics by making the entire row interactive.
**Action:** Apply this pattern whenever a Switch is paired with text labels in a Row.
