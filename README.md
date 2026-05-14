# Global Audio Router

A Jetpack Compose Android app that allows routing audio between your device's internal microphone and a Bluetooth microphone (SCO) using system-level permissions granted via Shizuku.

## Features
- Toggle between internal and Bluetooth microphone input
- Modern Android 12+ Audio Routing implementation
- Legacy Audio Routing fallback for older Android versions
- Execute system commands with Shizuku privileges

## Requirements
- Target SDK 35, Min SDK 24
- Shizuku running on device (with root or adb)

## Installation & Setup
1. Clone this repository
2. Open with Android Studio
3. Build and Run the project onto a device
4. Grant the app Shizuku permissions when prompted

## Build
```
./gradlew assembleDebug
```

## Testing
Tested with Shizuku v13.1.5+. Requires physical device to test Bluetooth Audio SCO connection.
