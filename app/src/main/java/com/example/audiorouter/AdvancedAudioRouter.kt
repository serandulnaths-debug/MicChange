package com.example.audiorouter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Build
import android.util.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class AdvancedAudioRouter(private val context: Context) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    suspend fun setBluetoothRouting(): Boolean {
        Log.d("AdvancedAudioRouter", "Attempting to route to Bluetooth")

        audioManager.mode = AudioManager.MODE_IN_COMMUNICATION

        if (ShizukuHelper.hasShizukuPermission.value) {
            val packageName = context.packageName
            ShizukuCommandRunner.runCommand(listOf("appops", "set", packageName, "10000", "allow"))
            ShizukuCommandRunner.runCommand(listOf("pm", "grant", packageName, "android.permission.MODIFY_AUDIO_ROUTING"))
        }

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val bluetoothDevice = audioManager.availableCommunicationDevices
                .firstOrNull {
                    it.type == AudioDeviceInfo.TYPE_BLUETOOTH_SCO ||
                    it.type == AudioDeviceInfo.TYPE_BLE_HEADSET
                }

            if (bluetoothDevice != null) {
                audioManager.setCommunicationDevice(bluetoothDevice)
            } else {
                false
            }
        } else {
            suspendCancellableCoroutine { continuation ->
                val receiver = object : BroadcastReceiver() {
                    override fun onReceive(c: Context?, intent: Intent?) {
                        if (intent?.action == AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED) {
                            val state = intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, AudioManager.SCO_AUDIO_STATE_ERROR)
                            if (state == AudioManager.SCO_AUDIO_STATE_CONNECTED) {
                                context.unregisterReceiver(this)
                                if (continuation.isActive) continuation.resume(true)
                            } else if (state == AudioManager.SCO_AUDIO_STATE_DISCONNECTED || state == AudioManager.SCO_AUDIO_STATE_ERROR) {
                                context.unregisterReceiver(this)
                                if (continuation.isActive) continuation.resume(false)
                            }
                        }
                    }
                }

                context.registerReceiver(receiver, IntentFilter(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED))

                @Suppress("DEPRECATION")
                audioManager.startBluetoothSco()

                @Suppress("DEPRECATION")
                audioManager.isBluetoothScoOn = true

                continuation.invokeOnCancellation {
                    context.unregisterReceiver(receiver)
                }
            }
        }
    }

    fun setInternalRouting() {
        Log.d("AdvancedAudioRouter", "Attempting to force internal routing")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            audioManager.clearCommunicationDevice()
        } else {
            @Suppress("DEPRECATION")
            audioManager.stopBluetoothSco()
            @Suppress("DEPRECATION")
            audioManager.isBluetoothScoOn = false
        }

        audioManager.mode = AudioManager.MODE_NORMAL
    }
}
