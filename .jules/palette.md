## 2024-06-29 - Prevent silent failures and improve accessibility for permission-gated controls
**Learning:** In Jetpack Compose applications relying on system-level permissions like Shizuku, interactive elements can silently fail if they aren't explicitly disabled when permissions are missing. Furthermore, these controls often lack context for screen readers.
**Action:** Always bind required system permission states directly to the `enabled` properties of relevant UI components, and attach `semantics { contentDescription = "..." }` to provide accessibility context.
