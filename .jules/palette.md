## 2024-05-15 - [Initial]
**Learning:** Initial Palette Journal creation.
**Action:** Ready to document UX/a11y learnings.

## 2024-05-15 - [Add Loading State for Async Audio Routing]
**Learning:** Found that long-running async operations tied to toggle switches (like Bluetooth SCO routing) lack native feedback, leading to user confusion or duplicate taps.
**Action:** Implemented a progress indicator within the `thumbContent` of Material 3 Switch to provide clear, immediate visual feedback while disabling the control during processing.
