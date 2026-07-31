## 2026-07-31 - Disable audio switch without Shizuku permissions
**Learning:** Silently failing on a toggle creates poor UX and confusion. The audio switch previously allowed interaction even when Shizuku permissions were missing, causing confusion when routing didn't work. Further, an icon-only switch lacks accessibility descriptions for screen readers.
**Action:** Always map system permission states (like `isShizukuAvailable` and `hasShizukuPermission`) to the `enabled` state of interactive components, and ensure interactive components have explicit `contentDescription` semantics.
