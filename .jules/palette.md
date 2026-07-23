## 2024-05-18 - Prevent Silent Failure on Global Audio Router
**Learning:** In the Global Audio Router app, interacting with the routing switch before Shizuku permissions are granted results in a silent failure or unexpected behavior, leading to a poor user experience.
**Action:** Always explicitly map system-level permission states (like Shizuku availability) to the `enabled` property of interactive UI components, preventing user interaction until preconditions are met. Additionally, provide semantic descriptions to switches for better accessibility.
