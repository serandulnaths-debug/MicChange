## 2024-10-24 - Shizuku Dependent UI Needs Explicit Disablement
**Learning:** In the Global Audio Router, interactive components fail silently if Shizuku permissions are missing, causing user confusion.
**Action:** Always map `isShizukuAvailable` and `hasShizukuPermission` to the `enabled` state of interactive controls (like Switches) to provide clear visual feedback when routing is unavailable.
