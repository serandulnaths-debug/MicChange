package com.example.audiorouter

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import rikka.shizuku.Shizuku
import java.lang.reflect.Method

object ShizukuCommandRunner {

    // Cache the reflection lookup to avoid overhead on every command execution
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

    suspend fun runCommand(command: List<String>): Boolean = withContext(Dispatchers.IO) {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return@withContext false
        }

        try {
            // newProcess is hidden API. We call it via cached reflection method
            // signature: static Process newProcess(String[] cmd, String[] env, String dir)

            // Execute command directly as an array instead of passing it to a shell
            val process = newProcessMethod.invoke(null, command.toTypedArray(), null, null) as Process

            // process.waitFor() is a blocking call, so we must run this on an IO dispatcher
            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
