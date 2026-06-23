## 2024-06-23 - Disable elements without permissions & accessibility labels
**Learning:** Toggles that perform system actions require explicit disabling when system permissions (like Shizuku) are missing to prevent confusing failures. Interactive toggles also need explicit `contentDescription` in Compose for screen readers.
**Action:** Always map system permission states to UI element `enabled` states and ensure interactive UI controls have `semantics { contentDescription = "..." }` attached.
