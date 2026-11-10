# WebForge Remote Assist — Android

An Android-first prototype for a user-controlled, AI-agnostic screen assistance tool.

## MVP scope
- Floating assistant entry point (Android overlay permission).
- User-initiated screen capture using Android MediaProjection consent.
- Accessibility service scaffold for explicitly enabled, user-authorized UI assistance.
- Persistent visible stop control and clear session state.

## Important limitations
- Android displays a system consent prompt before screen capture.
- Accessibility automation is opt-in and must remain visible and user-controlled.
- Secure screens, protected content, some apps, and OS dialogs may block capture or automation.
- This prototype does not yet connect to ChatGPT, Gemini, Claude, or any other AI service. AI integrations will be added only after the local capture and safety foundations are tested.
- Never use this app to bypass app security, capture passwords, or perform purchases/deletions without explicit confirmation.

## Build
Open this repository in Android Studio, or use the included GitHub Actions workflow to build a debug APK.
