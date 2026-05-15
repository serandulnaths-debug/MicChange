package com.example.audiorouter

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import rikka.shizuku.Shizuku

object ShizukuCommandRunner {
    suspend fun runCommand(command: List<String>): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return withContext(Dispatchers.IO) {
            try {
                // newProcess is hidden API. We can call it via reflection
                // signature: static Process newProcess(String[] cmd, String[] env, String dir)
                val method = Shizuku::class.java.getDeclaredMethod(
                    "newProcess",
                    Array<String>::class.java,
                    Array<String>::class.java,
                    String::class.java
                )
                method.isAccessible = true

                // Use array-based execution to prevent command injection
                val cmdArray = command.toTypedArray()
                val process = method.invoke(null, cmdArray, null, null) as Process

                val exitCode = process.waitFor()
                exitCode == 0
            } catch (ex: Exception) {
                Log.e("ShizukuCommandRunner", "Failed to run command", ex)
                false
            }
        }
    }
}
