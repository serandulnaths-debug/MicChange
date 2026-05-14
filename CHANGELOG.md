# Changelog

## [1.0.2] - 2024-05-14
### Fixed
- Fixed app crashing on startup silently because of missing Shizuku initialization exceptions tracking. Added proper UI safety fallbacks if Shizuku pinging throws exception.
- Restored `moe.shizuku.manager.permission.API_V23` back into AndroidManifest.xml.
- Recreated the Application Logo with proper Android vector-based adaptive icons so it properly shows on modern launchers.

## [1.0.1] - 2024-05-14
### Fixed
- Replaced direct `su` usage with Shizuku `newProcess` API for privileged command execution.
- Fixed `ShizukuProvider` class name in `AndroidManifest.xml` which caused app crashing on startup.
- Fixed `AdvancedAudioRouter` to use modern Android 12+ API `setCommunicationDevice` to reliably route audio to a Bluetooth SCO microphone.
- Implemented `BroadcastReceiver` for waiting on Android legacy API `startBluetoothSco` connection asynchronously.
- Updated UI to accurately reflect Bluetooth routing success status or alert user on failure.
- Fixed Shizuku Permission checking in `ShizukuHelper.kt` to only request permission if not already granted.
- Added missing `android.permission.MODIFY_AUDIO_ROUTING` permission in Manifest.

### Added
- comprehensive README.md.
- docs/PRODUCT_SPEC.md.
- docs/ARCHITECTURE.md.
- docs/TROUBLESHOOTING.md.
- docs/RELEASE_CHECKLIST.md.
