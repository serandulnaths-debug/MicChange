## 2026-08-01 - Disable interactive elements missing permissions
**Learning:** In the Global Audio Router app, interactive UI elements (like the audio routing switch) would silently fail if triggered without Shizuku permissions.
**Action:** Map Shizuku permission states directly to the enabled property of Jetpack Compose components to provide clear visual feedback that the action is unavailable.
