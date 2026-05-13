package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

object ShizukuCommandRunner {
    fun runCommand(command: String): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        try {
            // Usually we use Shizuku system service commands, but for simple appops we can try
            // a custom binder call. If we just need basic shell commands, we can use `sh` via Shizuku.
            val p = Runtime.getRuntime().exec(arrayOf("su", "-c", command))
            // Shizuku provides 'shizuku_newProcess' internally, but standard API has changed.
            // Using standard su command as fallback, but shizuku provides a way via Rikka API.

            p.waitFor()
            return p.exitValue() == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            return false
        }
    }
}
