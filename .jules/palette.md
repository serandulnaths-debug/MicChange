## 2023-10-27 - Disable functionality when prerequisites missing
**Learning:** Shizuku permission states must explicitly map to the `enabled` property of interactive Jetpack Compose UI components (like Switches) to prevent silent failures. Interactive elements should also always have semantic content descriptions for accessibility.
**Action:** Always check if a component depends on an external permission or state, and map that to its `enabled` property. Ensure `Modifier.semantics { contentDescription = "..." }` is used for screen readers.
