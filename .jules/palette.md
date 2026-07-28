## 2024-07-28 - Disable Global Audio Router switch when Shizuku permissions are missing

**Learning:** The audio router toggle silently fails and ignores input if Shizuku permissions are missing, causing user confusion. Interactive Jetpack Compose UI components that depend on Shizuku must be explicitly disabled and semantic descriptions added for accessibility when permissions are not granted.
**Action:** Explicitly map Shizuku permission states (e.g., `isShizukuAvailable` and `hasShizukuPermission`) to the `enabled` property of interactive UI components to prevent silent failures and ensure screen readers announce the state correctly.
