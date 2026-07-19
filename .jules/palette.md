## 2024-05-24 - Interactive Element State Mapping
**Learning:** Silently failing interactive elements without visual cues about permission states leads to poor user experience. Missing semantic labels on Switches prevents screen reader users from understanding the purpose of toggles.
**Action:** Always map system permission states directly to the `enabled` properties of interactive UI components, and attach `semantics { contentDescription = "..." }` for screen-reader accessibility.
