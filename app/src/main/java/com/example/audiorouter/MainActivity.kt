package com.example.audiorouter

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.selection.toggleable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var audioRouter: AdvancedAudioRouter

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { _ ->
        // Handle permission results if needed
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        audioRouter = AdvancedAudioRouter(this)

        requestBluetoothPermissions()

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AudioRouterScreen(audioRouter)
                }
            }
        }
    }

    private fun requestBluetoothPermissions() {
        val permissions = mutableListOf(Manifest.permission.MODIFY_AUDIO_SETTINGS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions.add(Manifest.permission.BLUETOOTH_CONNECT)
        } else {
            permissions.add(Manifest.permission.BLUETOOTH)
        }

        val notGranted = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }

        if (notGranted.isNotEmpty()) {
            requestPermissionLauncher.launch(notGranted.toTypedArray())
        }
    }
}

@Composable
fun AudioRouterScreen(audioRouter: AdvancedAudioRouter) {
    var isBluetoothRouted by remember { mutableStateOf(false) }
    val isShizukuAvailable = ShizukuHelper.isShizukuAvailable.value
    val hasShizukuPermission = ShizukuHelper.hasShizukuPermission.value
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Global Audio Router",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Shizuku Status
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isShizukuAvailable && hasShizukuPermission)
                    MaterialTheme.colorScheme.primaryContainer
                else MaterialTheme.colorScheme.errorContainer
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Shizuku Status:",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = "Available: $isShizukuAvailable")
                Text(text = "Permission: $hasShizukuPermission")

                if (isShizukuAvailable && !hasShizukuPermission) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { ShizukuHelper.requestPermission() }) {
                        Text("Grant Shizuku Permission")
                    }
                }
            }
        }

        Text(
            text = "Select Audio Input:",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = isBluetoothRouted,
                    role = Role.Switch,
                    onValueChange = { checked ->
                        if (checked) {
                            coroutineScope.launch {
                                val success = audioRouter.setBluetoothRouting()
                                isBluetoothRouted = success
                                if (!success) {
                                    Toast.makeText(
                                        context,
                                        "Bluetooth microphone is not available or routing was rejected.",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        } else {
                            audioRouter.setInternalRouting()
                            isBluetoothRouted = false
                        }
                    }
                )
                .padding(vertical = 8.dp) // Add some padding for the larger touch target
        ) {
            Text(
                text = "Internal Mic",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )

            Switch(
                checked = isBluetoothRouted,
                onCheckedChange = null,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "Bluetooth Mic",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Note: Global routing requires Shizuku. \nBluetooth routing uses the SCO profile.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}
