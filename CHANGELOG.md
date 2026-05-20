# Changelog

## [Unreleased]
### Changed
- Improved UX and Accessibility in MainActivity by applying `Modifier.toggleable` and `Role.Switch` to the entire row of the audio input switch, significantly increasing its touch target size.

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
