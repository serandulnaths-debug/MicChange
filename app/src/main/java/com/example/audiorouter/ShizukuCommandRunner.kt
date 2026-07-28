package com.example.audiorouter

import android.util.Log
import java.lang.reflect.Method
import rikka.shizuku.Shizuku

object ShizukuCommandRunner {

    // newProcess is hidden API. We can call it via reflection
    // signature: static Process newProcess(String[] cmd, String[] env, String dir)
    private val newProcessMethod: Method? by lazy {
        try {
            Shizuku::class.java.getDeclaredMethod(
                "newProcess",
                Array<String>::class.java,
                Array<String>::class.java,
                String::class.java
            ).apply {
                isAccessible = true
            }
        } catch (e: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to cache newProcess method", e)
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
