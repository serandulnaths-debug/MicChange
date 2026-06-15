## 2024-05-24 - Improve Compose Switch Touch Target
**Learning:** In Jetpack Compose, the default touch target for a Switch might only be the component itself. Users often expect the labels next to a switch to also be clickable to toggle the state.
**Action:** Apply `Modifier.toggleable(role = Role.Switch)` to the parent layout (like a `Row`) containing the Switch and its text labels, and set the internal Switch's `onCheckedChange` to `null`.
