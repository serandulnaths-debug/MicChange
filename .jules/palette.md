## 2024-07-29 - Disable audio switch without Shizuku permissions
**Learning:** Shizuku permissions are required for the app to function properly. When not available, interactive elements like switches should be explicitly disabled to prevent silent failures.
**Action:** Use the `enabled` property on interactive Jetpack Compose UI components to bind to Shizuku permission states (e.g., `isShizukuAvailable` and `hasShizukuPermission`).
