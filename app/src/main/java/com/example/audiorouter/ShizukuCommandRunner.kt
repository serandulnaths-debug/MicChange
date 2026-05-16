package com.example.audiorouter

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
            ).apply {
                isAccessible = true
            }
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to find newProcess method", ex)
            null
        }
    }

    suspend fun runCommand(commandArgs: List<String>): Boolean = withContext(Dispatchers.IO) {
        if (!Shizuku.pingBinder()) {
            Log.e("ShizukuCommandRunner", "Shizuku binder is not available.")
            return@withContext false
        }

        val method = newProcessMethod ?: return@withContext false

        return@withContext try {
            val process = method.invoke(null, commandArgs.toTypedArray(), null, null) as Process
            val exitCode = process.waitFor()
            exitCode == 0
        } catch (ex: Exception) {
            Log.e("ShizukuCommandRunner", "Failed to run command", ex)
            false
        }
    }
}
