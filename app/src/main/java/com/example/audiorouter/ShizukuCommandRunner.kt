package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

import java.lang.reflect.Method

object ShizukuCommandRunner {

    // Cache the reflection method to avoid expensive lookups on each command execution
    // signature: static Process newProcess(String[] cmd, String[] env, String dir)
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
            Log.e("ShizukuCommandRunner", "Failed to reflect newProcess", e)
            null
        }
    }

    fun runCommand(command: String): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return try {
            val method = newProcessMethod ?: return false

            val process = method.invoke(null, arrayOf("sh", "-c", command), null, null) as Process

            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
