package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

object ShizukuCommandRunner {

    // Cache the reflection method to avoid repeated expensive lookups
    private val newProcessMethod by lazy {
        val method = Shizuku::class.java.getDeclaredMethod(
            "newProcess",
            Array<String>::class.java,
            Array<String>::class.java,
            String::class.java
        )
        method.isAccessible = true
        method
    }

    fun runCommand(command: List<String>): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return try {
            // newProcess is hidden API. We call it via reflection.
            // Executing the command list directly without a shell wrapper prevents command injection.
            val process = newProcessMethod.invoke(null, command.toTypedArray(), null, null) as Process

            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
