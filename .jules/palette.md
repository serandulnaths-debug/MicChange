## 2024-05-30 - Map Shizuku permission states to UI enabled state
**Learning:** In the Global Audio Router app, interactive components (like the Switch) fail silently if Shizuku permission states (e.g., `isShizukuAvailable` and `hasShizukuPermission`) are not mapped to their `enabled` property.
**Action:** Always explicitly map Shizuku permission states to the `enabled` property of interactive Jetpack Compose UI components to prevent silent failures and improve UX clarity.
