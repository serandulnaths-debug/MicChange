package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

object ShizukuCommandRunner {
    // Cache the reflected newProcess method to avoid repeated expensive lookups
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

    // Security note: We accept a List<String> instead of a raw String and avoid `sh -c`
    // to prevent command injection vulnerabilities.
    fun runCommand(command: List<String>): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return try {
            // newProcess is hidden API. We can call it via reflection
            // signature: static Process newProcess(String[] cmd, String[] env, String dir)
            val process = newProcessMethod.invoke(null, command.toTypedArray(), null, null) as Process

            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
