# Product Specification

## Summary
Global Audio Router is a small Android application that lets users easily route their microphone input to an active Bluetooth device using SCO (Synchronous Connection-Oriented) protocol, or to their internal microphone. It leverages Shizuku to grant itself system-level audio routing permissions.

## Target Users
Advanced Android users or developers that require switching audio input source globally and have a rooted device or Shizuku setup via ADB.

## Core User Flows
1. User starts the app.
2. User grants Shizuku permission.
3. User toggles the mic input to "Bluetooth Mic".
4. App grants itself audio routing permission using Shizuku.
5. App routes audio to the Bluetooth SCO device.
6. User switches back to "Internal Mic" and audio routes back to normal.

## Constraints
- Shizuku must be running in the background.
- Requires Android 7.0+ (Min SDK 24).
- May not work reliably on all OEM forks due to custom audio routing logic.
