package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

import java.lang.reflect.Method

object ShizukuCommandRunner {
    private val newProcessMethod: Method by lazy {
        Shizuku::class.java.getDeclaredMethod(
            "newProcess",
            Array<String>::class.java,
            Array<String>::class.java,
            String::class.java
        ).apply {
            isAccessible = true
        }
    }

    fun runCommand(command: String): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return try {
            // newProcess is hidden API. We can call it via reflection
            // signature: static Process newProcess(String[] cmd, String[] env, String dir)
            val process = newProcessMethod.invoke(null, arrayOf("sh", "-c", command), null, null) as Process

            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
