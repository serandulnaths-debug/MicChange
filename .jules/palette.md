## 2025-01-24 - Disable unavailable interactions
**Learning:** When system-level permissions or services (like Shizuku) are unavailable, UI controls that depend on them must be explicitly disabled, and screen reader labels are needed to explain complex toggles.
**Action:** Explicitly map system permission states to UI element `enabled` states and add `semantics { contentDescription = "..." }` for screen readers.
