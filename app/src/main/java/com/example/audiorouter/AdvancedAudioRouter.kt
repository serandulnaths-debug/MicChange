package com.example.audiorouter

import android.content.Context
import android.media.AudioManager
import android.util.Log

class AdvancedAudioRouter(private val context: Context) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    @Suppress("DEPRECATION")
    fun setBluetoothRouting() {
        Log.d("AdvancedAudioRouter", "Attempting to force Bluetooth SCO routing via system settings")

        // Use AudioManager first
        audioManager.startBluetoothSco()
        audioManager.isBluetoothScoOn = true

        // Attempt to enforce via Shizuku shell commands
        if (ShizukuHelper.hasShizukuPermission.value) {
            // Android internal routing commands or global settings overrides
            // e.g., appops or global settings
            // Note: Direct shell commands for audio routing are limited.
            // Often we can force permission 'android.permission.MODIFY_AUDIO_ROUTING' via appops.

            val packageName = context.packageName
            val cmd = "appops set $packageName 10000 allow" // Internal permission might not work directly but we try standard ones
            ShizukuCommandRunner.runCommand(cmd)

            // Try enabling bluetooth sco directly if there are hidden commands
            // There's no direct "set audio mic" shell command in modern Android,
            // but we can grant our app MODIFY_AUDIO_ROUTING if it is defined.
            ShizukuCommandRunner.runCommand("pm grant $packageName android.permission.MODIFY_AUDIO_ROUTING")
        }
    }

    @Suppress("DEPRECATION")
    fun setInternalRouting() {
        Log.d("AdvancedAudioRouter", "Attempting to force internal routing")

        audioManager.stopBluetoothSco()
        audioManager.isBluetoothScoOn = false

        if (ShizukuHelper.hasShizukuPermission.value) {
            // val packageName = context.packageName
            // Cleanup routing permissions if needed
        }
    }
}
