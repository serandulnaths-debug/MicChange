## 2024-08-02 - Disable Interactive Elements Lacking Permissions
**Learning:** In applications relying on system-level privileges (like Shizuku), allowing interaction with UI elements that require these permissions when they are unavailable leads to silent failures and user confusion.
**Action:** Always map permission availability states directly to the `enabled` property of corresponding interactive components, and ensure proper accessibility descriptions (e.g. using semantics).
