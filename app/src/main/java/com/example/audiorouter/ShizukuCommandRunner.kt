package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

import java.lang.reflect.Method

object ShizukuCommandRunner {
    // newProcess is hidden API. We can call it via reflection
    // signature: static Process newProcess(String[] cmd, String[] env, String dir)
    private val newProcessMethod: Method by lazy {
        val method = Shizuku::class.java.getDeclaredMethod(
            "newProcess",
            Array<String>::class.java,
            Array<String>::class.java,
            String::class.java
        )
        method.isAccessible = true
        method
    }

    fun runCommand(command: Array<String>): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return try {
            val process = newProcessMethod.invoke(null, command, null, null) as Process

            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
