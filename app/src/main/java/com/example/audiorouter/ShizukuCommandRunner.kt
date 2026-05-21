package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

object ShizukuCommandRunner {
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
            val process = newProcessMethod.invoke(null, command.toTypedArray(), null, null) as Process
            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }

    // Keep old signature for compatibility, but use array
    fun runCommand(command: String): Boolean {
        return runCommand(listOf("sh", "-c", command))
    }
}
