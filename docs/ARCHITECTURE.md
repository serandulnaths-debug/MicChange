# Architecture

## Components
- `MainActivity`: Jetpack Compose UI showing connection states and the audio switch.
- `ShizukuHelper`: Manages Shizuku connection state, checks permissions, and requests them.
- `ShizukuCommandRunner`: Executes shell commands via Shizuku's process execution API.
- `AdvancedAudioRouter`: Manages the `AudioManager` to setup communication paths to either standard device speakers/mic or a Bluetooth SCO device. It abstracts Android 12+ capabilities vs legacy approaches.

## Data Flow
The user UI toggles the switch in `MainActivity`. That action invokes `AdvancedAudioRouter`. `AdvancedAudioRouter` calls `ShizukuCommandRunner` to grant system-level permissions via AppOps and Shell `pm grant` commands, and then modifies `AudioManager` state. State is returned asynchronously back to the UI which updates its visual indicators.
