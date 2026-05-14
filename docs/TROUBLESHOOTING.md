# Troubleshooting

## App Crashing on Launch
Ensure your `AndroidManifest.xml` `provider` is pointing to `rikka.shizuku.ShizukuProvider` and NOT `rikka.shizuku.provider.ShizukuProvider`.

## Bluetooth Mic not working
If the toggle switches back to `Internal Mic` automatically, it means `AdvancedAudioRouter` failed. Check:
- Are you connected to a Bluetooth device that supports SCO (like a headset)?
- Is Shizuku running and permission granted?

## App is completely unresponsive
Check logcat for "Shizuku binder is not available". If so, Shizuku might have died in the background or USB debugging was turned off.
