## 2024-06-27 - Map Permissions to UI state
**Learning:** System permission states (like Shizuku availability) should be mapped directly to the `enabled` states of interactive UI elements to prevent silent interaction failures.
**Action:** Always verify if an interactive element relies on system-level permissions and explicitly bind its enabled state to those permissions while attaching appropriate accessibility semantics.
