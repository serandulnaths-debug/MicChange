package com.example.audiorouter

import android.util.Log
import rikka.shizuku.Shizuku

import java.lang.reflect.Method

object ShizukuCommandRunner {
    // ⚡ Bolt: Cache the hidden API method via a lazy property to prevent expensive reflection
    // lookups on every runCommand invocation.
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

    fun runCommand(command: String): Boolean {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return false
        }

        return try {
            val process = newProcessMethod.invoke(null, arrayOf("sh", "-c", command), null, null) as Process

            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
