## 2026-07-30 - Disable interactive elements when permissions are missing
**Learning:** In applications relying on system-level privileges (like Shizuku), interactive components that depend on these permissions should be explicitly disabled when permissions are absent to prevent silent failures and improve user understanding.
**Action:** Always map underlying permission states to the `enabled` property of interactive UI components and add descriptive accessibility semantics.
