package com.example.audiorouter

import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import rikka.shizuku.Shizuku

object ShizukuHelper {
    const val TAG = "ShizukuHelper"
    val isShizukuAvailable = mutableStateOf(false)
    val hasShizukuPermission = mutableStateOf(false)

    private val binderReceivedListener = Shizuku.OnBinderReceivedListener {
        isShizukuAvailable.value = true
        checkPermission()
    }

    private val binderDeadListener = Shizuku.OnBinderDeadListener {
        isShizukuAvailable.value = false
        hasShizukuPermission.value = false
    }

    private val requestPermissionResultListener =
        Shizuku.OnRequestPermissionResultListener { requestCode, grantResult ->
            if (requestCode == 1000) {
                hasShizukuPermission.value = grantResult == PackageManager.PERMISSION_GRANTED
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Shizuku permission granted")
                } else {
                    Log.d(TAG, "Shizuku permission denied")
                }
            }
        }

    fun initialize() {
        Shizuku.addBinderReceivedListenerSticky(binderReceivedListener)
        Shizuku.addBinderDeadListener(binderDeadListener)
        Shizuku.addRequestPermissionResultListener(requestPermissionResultListener)

        isShizukuAvailable.value = Shizuku.pingBinder()
        if (isShizukuAvailable.value) {
            checkPermission()
        }
    }

    fun cleanup() {
        Shizuku.removeBinderReceivedListener(binderReceivedListener)
        Shizuku.removeBinderDeadListener(binderDeadListener)
        Shizuku.removeRequestPermissionResultListener(requestPermissionResultListener)
    }

    fun checkPermission() {
        if (!Shizuku.pingBinder()) {
            isShizukuAvailable.value = false
            hasShizukuPermission.value = false
            return
        }

        try {
            isShizukuAvailable.value = true
            hasShizukuPermission.value = Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED
        } catch (e: Exception) {
            if (e.cause is SecurityException) {
                Log.e(TAG, "Permission error", e)
            }
        }
    }

    fun requestPermission() {
        if (!Shizuku.pingBinder()) {
            return
        }

        if (Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED) {
            hasShizukuPermission.value = true
            return
        }

        if (Shizuku.shouldShowRequestPermissionRationale()) {
            Log.d(TAG, "Should show rationale for Shizuku")
            // Can show a toast or dialog here
        }
        Shizuku.requestPermission(1000)
    }
}
