package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku
import java.lang.reflect.Method

object ShizukuCommandRunner {
    private val newProcessMethod: Method? by lazy {
        try {
            Shizuku::class.java.getDeclaredMethod(
                "newProcess",
                Array<String>::class.java,
                Array<String>::class.java,
                String::class.java
            ).apply { isAccessible = true }
        } catch (e: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to get newProcess method", e)
            null
        }
    }

    fun runCommand(vararg command: String): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        val method = newProcessMethod ?: return false

        return try {
            val process = method.invoke(null, command, null, null) as Process
            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
