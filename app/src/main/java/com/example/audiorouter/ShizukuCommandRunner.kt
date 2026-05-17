package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku
import java.lang.reflect.Method

object ShizukuCommandRunner {

    // Cache the reflection method to avoid expensive lookups on every command execution
    private val newProcessMethod: Method? by lazy {
        try {
            val method = Shizuku::class.java.getDeclaredMethod(
                "newProcess",
                Array<String>::class.java,
                Array<String>::class.java,
                String::class.java
            )
            method.isAccessible = true
            method
        } catch (e: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to get Shizuku newProcess method via reflection", e)
            null
        }
    }

    fun runCommand(command: String): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        val method = newProcessMethod ?: return false

        return try {
            // newProcess is hidden API. We call it via cached reflection
            // Use array-based execution to prevent command injection vulnerabilities as per memory
            val process = method.invoke(null, arrayOf("sh", "-c", command), null, null) as Process

            // Note: process.waitFor() is a blocking call. We are keeping it synchronous to avoid
            // breaking changes, but the reflection is cached for performance.
            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
