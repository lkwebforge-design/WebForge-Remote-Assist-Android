package com.webforge.remoteassist

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
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
        root.addView(label("Diagnostic build • No sensitive permissions"))
        root.addView(label("This temporary build only checks whether the basic app package installs. Screen capture, overlays, accessibility and AI actions are disabled."))
        setContentView(root)
    }
}
