package com.webforge.remoteassist

import android.app.Activity
import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val captureRequest = 4101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 48, 32, 32)
            setBackgroundColor(0xFF07110D.toInt())
        }

        fun label(text: String, size: Float = 16f) = TextView(this).apply {
            this.text = text
            textSize = size
            setTextColor(0xFFF2FFF7.toInt())
            setPadding(0, 12, 0, 12)
        }

        root.addView(label("WEBFORGE", 14f))
        root.addView(label("Remote Assist", 30f))
        root.addView(label("Your screen. Your permission. Your control."))
        root.addView(label("Prototype 0.1 • Android"))

        root.addView(Button(this).apply {
            text = "Enable floating assistant"
            setOnClickListener {
                if (!Settings.canDrawOverlays(this@MainActivity)) {
                    startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:$packageName")))
                } else {
                    startService(Intent(this@MainActivity, FloatingAssistantService::class.java))
                }
            }
        })

        root.addView(Button(this).apply {
            text = "Start screen sharing"
            setOnClickListener {
                val manager = getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
                startActivityForResult(manager.createScreenCaptureIntent(), captureRequest)
            }
        })

        root.addView(Button(this).apply {
            text = "Stop floating assistant"
            setOnClickListener {
                stopService(Intent(this@MainActivity, FloatingAssistantService::class.java))
                stopService(Intent(this@MainActivity, ScreenCaptureService::class.java))
            }
        })

        root.addView(label("Screen sharing starts only after Android's system permission prompt. AI connections and automated actions are not enabled in this prototype."))
        setContentView(root)
    }

    @Deprecated("Deprecated by Android API; retained for broad device compatibility in this prototype.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == captureRequest && resultCode == RESULT_OK && data != null) {
            val intent = Intent(this, ScreenCaptureService::class.java).apply {
                putExtra(ScreenCaptureService.EXTRA_RESULT_CODE, resultCode)
                putExtra(ScreenCaptureService.EXTRA_DATA, data)
            }
            startForegroundService(intent)
        }
    }
}
