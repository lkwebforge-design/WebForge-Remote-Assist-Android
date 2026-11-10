package com.webforge.remoteassist

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class WebForgeAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // MVP scaffold: no automatic actions are performed.
        // Future actions must be explicit, visible, user-authorized and cancellable.
    }

    override fun onInterrupt() {
        // Stop any future in-progress assistance here.
    }
}
